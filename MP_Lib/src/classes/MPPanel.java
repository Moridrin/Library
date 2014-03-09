/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import interfaces.*;

/**
 *
 * @author jeroen
 */
public class MPPanel extends javax.swing.JPanel {

    private SuperClass superClass;

    public SuperClass getParentFrame() {
        return superClass;
    }

    public void setParentFrame(SuperClass superClass) {
        this.superClass = superClass;
    }
}
