package entity;

import java.util.Collection;

/**
 * Created by k.kotov on 11.09.2017.
 */
public class TopicsEntity {
    private int topicId;
    private String topicName;
    private String topicDescription;
    private Collection<ListoftopicsinmaterialEntity> listoftopicsinmaterialsByTopicId;
    private Collection<SectionsEntity> sectionsByTopicId;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicsEntity that = (TopicsEntity) o;

        if (topicId != that.topicId) return false;
        if (topicName != null ? !topicName.equals(that.topicName) : that.topicName != null) return false;
        if (topicDescription != null ? !topicDescription.equals(that.topicDescription) : that.topicDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicId;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        result = 31 * result + (topicDescription != null ? topicDescription.hashCode() : 0);
        return result;
    }

    public Collection<ListoftopicsinmaterialEntity> getListoftopicsinmaterialsByTopicId() {
        return listoftopicsinmaterialsByTopicId;
    }

    public void setListoftopicsinmaterialsByTopicId(Collection<ListoftopicsinmaterialEntity> listoftopicsinmaterialsByTopicId) {
        this.listoftopicsinmaterialsByTopicId = listoftopicsinmaterialsByTopicId;
    }

    public Collection<SectionsEntity> getSectionsByTopicId() {
        return sectionsByTopicId;
    }

    public void setSectionsByTopicId(Collection<SectionsEntity> sectionsByTopicId) {
        this.sectionsByTopicId = sectionsByTopicId;
    }
}
