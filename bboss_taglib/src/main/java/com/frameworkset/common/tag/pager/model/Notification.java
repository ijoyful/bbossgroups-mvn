/*****************************************************************************
 *                                                                           *
 *  This file is part of the frameworkset distribution.                      *
 *  Documentation and updates may be get from  biaoping.yin the author of    *
 *  this framework							     							 *
 *                                                                           *
 *  Sun Public License Notice:                                               *
 *                                                                           *
 *  The contents of this file are subject to the Sun Public License Version  *
 *  1.0 (the "License"); you may not use this file except in compliance with *
 *  the License. A copy of the License is available at http://www.sun.com    * 
 *                                                                           *
 *  The Original Code is tag. The Initial Developer of the Original          *    
 *  Code is biaoping.yin. Portions created by biaoping.yin are Copyright     *
 *  (C) 2004.  All Rights Reserved.                                          *
 *                                                                           *
 *  GNU Public License Notice:                                               *
 *                                                                           *
 *  Alternatively, the contents of this file may be used under the terms of  *
 *  the GNU Lesser General Public License (the "LGPL"), in which case the    *
 *  provisions of LGPL are applicable instead of those above. If you wish to *
 *  allow use of your version of this file only under the  terms of the LGPL *
 *  and not to allow others to use your version of this file under the SPL,  *
 *  indicate your decision by deleting the provisions above and replace      *
 *  them with the notice and other provisions required by the LGPL.  If you  *
 *  do not delete the provisions above, a recipient may use your version of  *
 *  this file under either the SPL or the LGPL.                              *
 *                                                                           *
 *  biaoping.yin (yin-bp@163.com)                                            * 
 *                                                                           *
 *****************************************************************************/
package com.frameworkset.common.tag.pager.model;

/**
 * 提示信息，当记录数为零时，设置提示信息
 * @author biaoping.yin
 * created on 2005-5-30
 * version 1.0 
 */
public class Notification extends UniqueHelper implements ModelObject{
    /**
     * 提示信息      
     */
    private String notification;
    
    /**
     * 是否输出提示信息
     */
    private boolean output = false;

    /**
     * @return Returns the notification.
     */
    public String getNotification() {
        return notification;
    }
    /**
     * @param notification The notification to set.
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }
    /**
     * @return Returns the output.
     */
    public boolean isOutput() {
        return output;
    }
    /**
     * @param output The output to set.
     */
    public void setOutput(boolean output) {
        this.output = output;
    }
}
