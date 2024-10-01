## OTP 1 Week 7 Home assingment

This assignment is part of Metropolia UAS "OTP1" cource. Aim for this assignment is to create Java application that tracks sports activities, continuous integration and deployment using Jenkins and containerization with Docker.
After building the docker image with jenkins, the image is pulled and ran with virtual machine in Linux environment.

### Technologies Used:

  - **Java**: Application development
  - **Jenkins**: Continuous Integration/Continuous Deployment (CI/CD)
  - **Docker**: Containerization
  - **Virtual Machine**: Linux environment for running the container

### Virtual machine
- Virtual machine used: [Oracle VirtualBox](https://www.virtualbox.org/)
- VM OS used: [Ubuntu 24.04.1 LTS](https://ubuntu.com/download/desktop)

### Running the project

To run the project ensure you have docker installed and running.

1. Ensure docker service is active (linux)
```
sudo systemctl status snap.docker.dockerd
```

2. If it's not running, start it (linux)
```
sudo systemctl start snap.docker.dockerd
```

3. Pull the Docker image
```
docker pull teemukallio/wk7sportstimetracker:latest
```

4. Run the Docker container
```
docker run -it --rm teemukallio/wk7sportstimetracker:latest
```

