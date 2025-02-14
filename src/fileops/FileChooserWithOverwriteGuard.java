/*
 * Copyright (C) 2021 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fileops;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Just a simple tweak on <code>JFileChooser</code> so that it asks before
 * overwriting an existing file. This is done simply by overriding
 * <code>JFileChooser.approveSelection()</code>.
 * @author Alonso del Arte, based on the tutorial at
 * http://www.thepcwizard.in/2013/05/complete-guide-to-jfilechooser.html
 */
public class FileChooserWithOverwriteGuard extends JFileChooser {

    @Override
    public void approveSelection() {
        File file = this.getSelectedFile();
        if (file.exists()) {
            int confResp = JOptionPane.showConfirmDialog(this,
                    "Do you want to overwrite the existing file?",
                    file.getName() + " already exists",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            switch (confResp) {
                case JOptionPane.YES_OPTION:
                    super.approveSelection();
                    break;
                case JOptionPane.NO_OPTION:
                    return;
                case JOptionPane.CLOSED_OPTION:
                case JOptionPane.CANCEL_OPTION:
                    this.cancelSelection();
                    return;
            }
        }
        super.approveSelection();
    }

}
