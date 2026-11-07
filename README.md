# \# AI File System Assistant using MCP Tools

# 

# An AI-powered file management application built using \*\*Java, Spring Boot, Spring AI, Model Context Protocol (MCP), and OpenAI\*\*. It allows users to interact with their file system through natural-language instructions instead of manually performing file operations.

# 

# \## Project Overview

# 

# The AI File System Assistant connects an AI-powered chat interface with file-management tools through the Model Context Protocol (MCP).

# 

# Users can enter instructions in a web interface, and the AI can identify the appropriate tool and execute the requested operation through the MCP server.

# 

# \### Key Features

# 

# \- \*\*List Files:\*\* View files and folders in the configured file system.

# \- \*\*Create Folder:\*\* Create a new folder by providing its name.

# \- \*\*Move Files:\*\* Move a file from one location to another.

# \- \*\*AI-Powered Interaction:\*\* Use natural-language instructions to request file operations.

# \- \*\*MCP Integration:\*\* Connect the AI client to the MCP server using Streamable HTTP.

# \- \*\*Web Interface:\*\* Interact with the assistant through a Spring Boot and Thymeleaf interface.

# 

# \## Technologies Used

# 

# | Technology | Purpose |

# |---|---|

# | Java | Programming language |

# | Spring Boot | Application development |

# | Spring AI | AI integration and tool calling |

# | Model Context Protocol (MCP) | Communication between AI and tools |

# | OpenAI API | Language model integration |

# | Thymeleaf | Web interface |

# | Maven | Dependency and build management |

# | HTML | Frontend structure |

# | Git \& GitHub | Version control |

# 

# \## System Architecture

# 

# The application consists of two independent Spring Boot applications.

# 

# ```mermaid

# flowchart TD

# &#x20;   A\[User] --> B\[Thymeleaf Web Interface]

# &#x20;   B --> C\[Spring Boot MCP Client]

# &#x20;   C --> D\[Spring AI ChatClient]

# &#x20;   D --> E\[OpenAI Model]

# &#x20;   E --> D

# &#x20;   D --> F\[MCP Tool Callback]

# &#x20;   F --> G\[MCP Server]

# &#x20;   G --> H\[listFiles]

# &#x20;   G --> I\[createFolder]

# &#x20;   G --> J\[moveFile]

# &#x20;   H --> K\[Configured File System]

# &#x20;   I --> K

# &#x20;   J --> K

# &#x20;   K --> G

# &#x20;   G --> C

# &#x20;   C --> B

# &#x20;   B --> A

# ```

# 

# \### How It Works

# 

# 1\. The user enters a file-management request through the web interface.

# 2\. The Spring Boot client receives the request.

# 3\. Spring AI sends the request to the configured OpenAI model.

# 4\. The model determines whether an available MCP tool is required.

# 5\. The MCP client invokes the selected tool on the MCP server.

# 6\. The MCP server executes the requested file operation.

# 7\. The result is returned to the client and displayed to the user.

# 

# \## Project Structure

# 

# ```text

# Project-Ai/

# │

# ├── Project-Ai-Client/

# │   └── Project-Ai-Client/

# │       ├── src/main/java/

# │       │   └── com/iss/Project\_Ai\_Client/

# │       │       ├── controllers/

# │       │       ├── services/

# │       │       └── ProjectAiClientApplication.java

# │       │

# │       ├── src/main/resources/

# │       │   ├── templates/

# │       │   │   └── aihome.html

# │       │   └── application.properties

# │       │

# │       └── pom.xml

# │

# ├── Project-Ai-Server/

# │   └── Project-Ai-Server/

# │       ├── src/main/java/

# │       │   └── com/iss/Project\_Ai\_Server/

# │       │       ├── services/

# │       │       │   └── AiService.java

# │       │       └── ProjectAiServerApplication.java

# │       │

# │       ├── src/main/resources/

# │       │   └── application.properties

# │       │

# │       └── pom.xml

# │

# └── README.md

# ```

# 

# \## Setup and Installation

# 

# \### Prerequisites

# 

# \- Java Development Kit (JDK), compatible with the project's Maven configuration

# \- IntelliJ IDEA or another Java IDE

# \- Git

# \- OpenAI API key

# 

# \### 1. Clone the Repository

# 

# ```bash

# git clone https://github.com/thayeeb14/AI-File-System-Assistant.git

# ```

# 

# Open the cloned project in IntelliJ IDEA.

# 

# \### 2. Configure the OpenAI API Key

# 

# The client application reads the API key from an environment variable.

# 

# On Windows Command Prompt, set it before starting the client:

# 

# ```cmd

# set OPENAI\_API\_KEY=your\_openai\_api\_key

# ```

# 

# Replace the placeholder with your own API key. Never commit your actual API key to GitHub.

# 

# \### 3. Start the MCP Server

# 

# Open a terminal and navigate to:

# 

# ```cmd

# cd Project-Ai-Server\\Project-Ai-Server

# ```

# 

# Run:

# 

# ```cmd

# mvnw.cmd spring-boot:run

# ```

# 

# The MCP server is configured to run on port `8080`, which is the address used by the client.

# 

# \### 4. Start the MCP Client

# 

# Open a second terminal and navigate to:

# 

# ```cmd

# cd Project-Ai-Client\\Project-Ai-Client

# ```

# 

# Run:

# 

# ```cmd

# mvnw.cmd spring-boot:run

# ```

# 

# The client is configured to run on port `8081`.

# 

# \### 5. Open the Application

# 

# Visit the following address in your browser:

# 

# ```text

# http://localhost:8081

# ```

# 

# You can now interact with the AI File System Assistant.

# 

# \## MCP Tools

# 

# The MCP server exposes the following tools:

# 

# | Tool | Description |

# |---|---|

# | `listFiles()` | Lists files and folders in the configured location. |

# | `createFolder(folderName)` | Creates a folder using the supplied folder name. |

# | `moveFile(sourcePath, targetPath)` | Moves a file from its source path to its target path. |

# 

# \## Configuration

# 

# The client and server use separate `application.properties` files.

# 

# \*\*Client configuration:\*\*

# 

# \- Application port: `8081`

# \- OpenAI API key: `OPENAI\_API\_KEY` environment variable

# \- MCP server URL: `http://localhost:8080`

# \- MCP client transport: Streamable HTTP

# 

# \*\*Server configuration:\*\*

# 

# \- MCP server protocol: Streamable HTTP

# 

# \## Screenshots

# 

# Screenshots of the project interface and execution are available in the repository root. They demonstrate the application interface and its working functionality.

# 

# \## Learning Outcomes

# 

# Through this project, I gained practical experience in:

# 

# \- Developing applications using Java and Spring Boot.

# \- Integrating Large Language Models using Spring AI.

# \- Understanding Model Context Protocol and tool calling.

# \- Building communication between independent Spring Boot applications.

# \- Creating REST-style web interfaces with Thymeleaf.

# \- Managing application configuration and API credentials.

# \- Using Git and GitHub for version control.

# 

# \## Future Enhancements

# 

# \- Add file deletion and rename operations with appropriate safeguards.

# \- Support file search and filtering.

# \- Add file-content summarization.

# \- Implement user authentication and authorization.

# \- Add operation history and activity logs.

# \- Improve file-operation validation and error handling.

# 

# \## Author

# 

# \*\*Thayeeb\*\*

# 

# GitHub: \[@thayeeb14](https://github.com/thayeeb14)

# 

# \## Repository

# 

# \[AI File System Assistant using MCP Tools](https://github.com/thayeeb14/AI-File-System-Assistant)

