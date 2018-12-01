package model.dto;

import model.entity.Thing;
import java.util.ArrayList;
import java.util.List;

public class KnightDTO {

    private List<Thing> equipmentThings = new ArrayList<>();
    private Thing leftHand;
    private Thing rightHand;
    private Thing body;

    public void setEquipmentThings(List<Thing> equipmentThings) {
        this.equipmentThings = equipmentThings;
    }

    public List<Thing> getEquipmentThings() {
        return equipmentThings;
    }

    public void addEquipmentThings(Thing thing) {
        equipmentThings.add(thing);
    }

    public Thing getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Thing leftHand) {
        this.leftHand = leftHand;
    }

    public Thing getBody() {
        return body;
    }

    public void setBody(Thing body) {
        this.body = body;
    }

    public Thing getRightHand() {
        return rightHand;
    }

    public void setRightHand(Thing rightHand) {
        this.rightHand = rightHand;
    }

}
