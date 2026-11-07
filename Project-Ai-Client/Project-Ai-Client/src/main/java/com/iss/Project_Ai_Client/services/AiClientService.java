package com.iss.Project_Ai_Client.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
public class AiClientService {
    ChatClient chatClient;
    ToolCallbackProvider mcpToolProvider;

    public AiClientService(ChatClient.Builder chatClientBuilder, ToolCallbackProvider mcpToolProvider)
    {
        chatClient = chatClientBuilder.defaultSystem("You are a helpful file system assistant. You only have access to files " +
                        "inside a local sandbox directory. Always check what files exist before " +
                        "organizing them. Be precise when moving files.")
                .build();

        this.mcpToolProvider = mcpToolProvider;
    }

    public String chat(String prompt) {

        ToolCallback[] callbacks = mcpToolProvider.getToolCallbacks();

        System.out.println("Available MCP Tools:");
        for (ToolCallback callback : callbacks) {
            System.out.println(callback.getToolDefinition());
        }

        String progressToken = "token-" + new Random().nextInt();

        return chatClient.prompt()
                .user(prompt)
                .toolContext(Map.of("progressToken", progressToken))
                .tools(mcpToolProvider)
                .call()
                .content();
    }
}