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
public class MPFrame extends javax.swing.JFrame {

    private SuperClass superClass;

    public MPFrame(SuperClass superClass) {
        this.superClass = superClass;
    }

    public SuperClass getParentFrame() {
        return superClass;
    }
}
