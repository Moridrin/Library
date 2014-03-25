/**********************\
* Moridrin Productions *
* Created by:          *
*      Jeroen Berkvens *
\**********************/
//<editor-fold defaultstate="collapsed" desc="Jibberish">
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;
//</editor-fold>

/**
 *
 * @author jeroen
 */
public class UnknownSmallValue extends Exception
{
      public UnknownSmallValue() {}

      public UnknownSmallValue(String message)
      {
         super(message);
      }
 }
