package model;

public class PMCP {
    private String name;
    private String version;
    private String rule;
    private String publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "PMCP{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", rule='" + rule + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
