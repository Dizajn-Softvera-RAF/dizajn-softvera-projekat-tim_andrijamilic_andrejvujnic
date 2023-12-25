package raf.dsw.classycraft.app.classyRepository.command.implementation;

import raf.dsw.classycraft.app.classyRepository.command.AbstractCommand;
import raf.dsw.classycraft.app.classyRepository.implementation.Diagram;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.DiagramElement;
import raf.dsw.classycraft.app.classyRepository.implementation.DiagramElements.interClass.InterClass;
import raf.dsw.classycraft.app.classyRepository.implementation.connection.Connection;

import java.awt.*;
import java.util.ArrayList;

public class MoveCommand extends AbstractCommand {

    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private int adjustedX;
    private int adjustedY;
    private ArrayList<DiagramElement> selectedModels;

    public MoveCommand(int startX, int startY, int endX, int endY, ArrayList<DiagramElement> selectedModels) {
        this.startX = startX;
        this.startY = startY;
        this.adjustedX = endX - startX;
        this.adjustedY = endY - startY;
        this.selectedModels = selectedModels;
    }
    @Override
    public void doCommand() {
        performMoveCommand(false);
    }

    @Override
    public void undoCommand() {
        performMoveCommand(true);
    }

    public void performMoveCommand(boolean reversed) {
        for (DiagramElement model : selectedModels) {
            if (model instanceof Connection) continue;

            InterClass pojamModel = (InterClass) model;

            Point newPoint = null;
            if (reversed) newPoint = new Point((int) (pojamModel.getPosition().getX() - adjustedX), (int) (pojamModel.getPosition().getY() - adjustedY));
            else newPoint = new Point((int) (pojamModel.getPosition().getX() + adjustedX), (int) (pojamModel.getPosition().getY() + adjustedY));

            pojamModel.setPosition(newPoint);

        }
    }


}
