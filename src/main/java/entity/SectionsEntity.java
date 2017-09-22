package entity;

/**
 * Created by k.kotov on 11.09.2017.
 */
public class SectionsEntity {
    private int sectionId;
    private String sectionName;
    private String sectionContent;
    private int sectionTopicId;
    private TopicsEntity topicsBySectionTopicId;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public int getSectionTopicId() {
        return sectionTopicId;
    }

    public void setSectionTopicId(int sectionTopicId) {
        this.sectionTopicId = sectionTopicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionsEntity that = (SectionsEntity) o;

        if (sectionId != that.sectionId) return false;
        if (sectionTopicId != that.sectionTopicId) return false;
        if (sectionName != null ? !sectionName.equals(that.sectionName) : that.sectionName != null) return false;
        if (sectionContent != null ? !sectionContent.equals(that.sectionContent) : that.sectionContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sectionId;
        result = 31 * result + (sectionName != null ? sectionName.hashCode() : 0);
        result = 31 * result + (sectionContent != null ? sectionContent.hashCode() : 0);
        result = 31 * result + sectionTopicId;
        return result;
    }

    public TopicsEntity getTopicsBySectionTopicId() {
        return topicsBySectionTopicId;
    }

    public void setTopicsBySectionTopicId(TopicsEntity topicsBySectionTopicId) {
        this.topicsBySectionTopicId = topicsBySectionTopicId;
    }
}
