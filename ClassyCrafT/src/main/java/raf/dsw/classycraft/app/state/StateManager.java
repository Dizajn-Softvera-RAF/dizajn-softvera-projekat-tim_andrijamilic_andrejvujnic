package raf.dsw.classycraft.app.state;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.state.concrete.*;

public class StateManager {

    private State currentState;
    private AddConnectionState addConnectionState;
    private AddClassState addClassState;
    private EditState editState;
    private MoveState moveState;
    private SelectState selectState;
    private ZoomState zoomState;

    public StateManager(){
        initState();
    }
    private void initState(){
        addClassState = new AddClassState();
        addConnectionState = new AddConnectionState();
        editState = new EditState();
        moveState = new MoveState();
        selectState = new SelectState();
        zoomState = new ZoomState();
        currentState = addClassState;
    }

    public State getCurrentState(){ return currentState; }

    public void setAddClassState(){currentState = addClassState;
    }
    public void setAddConnectionStateState(){
        currentState = addConnectionState;
    }
    public void setEditState(){ currentState = editState; }
    public void setMoveState(){ currentState = moveState; }
    public void setSelectState(){ currentState = selectState; }
    public void setZoomState(){ currentState = zoomState; }
}
