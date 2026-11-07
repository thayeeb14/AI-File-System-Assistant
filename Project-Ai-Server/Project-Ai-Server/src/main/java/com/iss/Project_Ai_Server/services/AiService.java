package com.iss.Project_Ai_Server.services;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AiService {

    Path SANDBOX = Paths.get("C:\\Users\\Thayeeb\\Downloads\\SANDBOX");

    @McpTool(description = "List all files and subdirectories inside the sandbox folder, showing names and extensions.")
    public List<String> listFiles() throws IOException {

        List<String> files = new ArrayList<>();

        File[] contents = SANDBOX.toFile().listFiles();

        if (contents != null) {
            for (File file : contents) {
                files.add(file.getName());
            }
        }

        return files;
    }

    @McpTool(description = "Create a new folder inside the sandbox. Parameter 'folderName' should be a simple name, not an absolute path.")
    public String createFolder(String folderName) throws IOException
    {
        if (folderName == null || folderName.isBlank() || folderName.contains("/") || folderName.contains("\\") || folderName.equals(".") || folderName.equals(".."))
        {
            return "invalid folder name provide proper name";
        }

        File folder = new File(SANDBOX.toFile(), folderName);

        if (folder.exists()) {
            return "folder already exists";
        }

        if (folder.mkdir()) {
            return "folder created successfully";
        }

        return "can not create folder";
    }

    @McpTool(description = "Move a file from its current path to a new location inside the sandbox. Both paths must be relative to the sandbox root.")
    public String moveFile(String sourcePath, String targetPath) throws IOException
    {
        File source = new File(SANDBOX.toFile(), sourcePath);
        File target = new File(SANDBOX.toFile(), targetPath);

        if (!source.exists()) {
            return "file does not exist";
        }

        if (target.exists()) {
            return "file already exists";
        }

        Files.move(source.toPath(), target.toPath());

        return "file moved";
    }
}

