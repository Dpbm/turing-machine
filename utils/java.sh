#!/usr/bin/bash

# Configure java openjdk 8 for Opensuse

sudo zypper install java-1_8_0-openj9-devel \
                    java-1_8_0-openj9-devel \
                    java-1_8_0-openj9-headless \
                    java-1_8_0-openjdk \
                    java-1_8_0-openjdk-devel \
                    java-1_8_0-openjdk-headless

if [[ $(echo $SHELL | cut -d '/' -f 4) == 'zsh' ]] 
then
    echo "export JAVA_HOME=/usr/lib64/jvm/java-1.8.0-openj9-1.8.0/" >> $HOME/.zshrc
    echo "Added JAVA_HOME to your .zshrc, please run: "
    echo "source $HOME/.zshrc"
else
    echo "export JAVA_HOME=/usr/lib64/jvm/java-1.8.0-openj9-1.8.0/" >> $HOME/.bashrc
    echo "Added JAVA_HOME to your .bashrc, please run: "
    echo "source $HOME/.bashrc"
fi