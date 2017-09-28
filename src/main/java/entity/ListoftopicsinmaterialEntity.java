package entity;


import javax.persistence.*;

@Entity
@Table(name = "listoftopicsinmaterial")
public class ListoftopicsinmaterialEntity {

    @Id
    @GeneratedValue
    @Column(name = "list_ID")
    private int listId;

    @Column(name = "list_material_ID")
    private int listMaterialId;

    @Column(name = "list_topic_ID")
    private int listTopicId;

    @ManyToOne
    @JoinColumn(name = "list_material_ID", insertable = false, updatable = false)
    private MaterialsEntity materialsByListMaterialId;

    @ManyToOne
    @JoinColumn(name = "list_topic_ID", insertable = false, updatable = false)
    private TopicsEntity topicsByListTopicId;




    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public int getListMaterialId() {
        return listMaterialId;
    }

    public void setListMaterialId(int listMaterialId) {
        this.listMaterialId = listMaterialId;
    }

    public int getListTopicId() {
        return listTopicId;
    }

    public void setListTopicId(int listTopicId) {
        this.listTopicId = listTopicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListoftopicsinmaterialEntity that = (ListoftopicsinmaterialEntity) o;

        if (listId != that.listId) return false;
        if (listMaterialId != that.listMaterialId) return false;
        if (listTopicId != that.listTopicId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = listId;
        result = 31 * result + listMaterialId;
        result = 31 * result + listTopicId;
        return result;
    }

    public MaterialsEntity getMaterialsByListMaterialId() {
        return materialsByListMaterialId;
    }

    public void setMaterialsByListMaterialId(MaterialsEntity materialsByListMaterialId) {
        this.materialsByListMaterialId = materialsByListMaterialId;
    }

    public TopicsEntity getTopicsByListTopicId() {
        return topicsByListTopicId;
    }

    public void setTopicsByListTopicId(TopicsEntity topicsByListTopicId) {
        this.topicsByListTopicId = topicsByListTopicId;
    }
}
