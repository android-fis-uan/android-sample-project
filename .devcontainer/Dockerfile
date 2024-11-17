FROM cimg/android:2024.11.1

## Configure GCloud CLI
RUN sudo apt update && sudo apt install -y apt-transport-https ca-certificates gnupg curl
RUN sudo curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo gpg --dearmor -o /usr/share/keyrings/cloud.google.gpg
RUN echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list 
RUN sudo apt update -y && sudo apt install google-cloud-cli -y
