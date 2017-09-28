package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "materials")
public class MaterialsEntity {

    @Id
    @GeneratedValue
    @Column(name = "material_ID")
    private int materialId;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "material_description")
    private String materialDescription;

    @OneToMany(mappedBy = "materialsByListMaterialId")
    private Collection<ListoftopicsinmaterialEntity> listoftopicsinmaterialsByMaterialId;

    @OneToMany(mappedBy = "materialsByUserMaterialId")
    private Collection<UsersEntity> usersByMaterialId;

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialsEntity that = (MaterialsEntity) o;

        if (materialId != that.materialId) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = materialId;
        result = 31 * result + (materialName != null ? materialName.hashCode() : 0);
        result = 31 * result + (materialDescription != null ? materialDescription.hashCode() : 0);
        return result;
    }

    public Collection<ListoftopicsinmaterialEntity> getListoftopicsinmaterialsByMaterialId() {
        return listoftopicsinmaterialsByMaterialId;
    }

    public void setListoftopicsinmaterialsByMaterialId(Collection<ListoftopicsinmaterialEntity> listoftopicsinmaterialsByMaterialId) {
        this.listoftopicsinmaterialsByMaterialId = listoftopicsinmaterialsByMaterialId;
    }

    public Collection<UsersEntity> getUsersByMaterialId() {
        return usersByMaterialId;
    }

    public void setUsersByMaterialId(Collection<UsersEntity> usersByMaterialId) {
        this.usersByMaterialId = usersByMaterialId;
    }
}

