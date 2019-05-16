package ru.cft.aml.seabattler.conf;

public class ConfigWrapper {

    public String teamName;

    public Integer playgroundId;

    public String selfAddr;

    public ConfigWrapper(String teamName, Integer playgroundId, String selfAddr) {
        this.teamName = teamName;
        this.playgroundId = playgroundId;
        this.selfAddr = selfAddr;
    }
}
