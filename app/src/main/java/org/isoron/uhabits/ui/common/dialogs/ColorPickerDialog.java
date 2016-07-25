/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.ui.common.dialogs;

import android.content.*;

import org.isoron.uhabits.*;
import org.isoron.uhabits.utils.*;

/**
 * Dialog that allows the user to choose a color.
 */
public class ColorPickerDialog extends com.android.colorpicker.ColorPickerDialog
{
    public static ColorPickerDialog newInstance(int paletteColor)
    {
        ColorPickerDialog dialog = new ColorPickerDialog();
        Context context = dialog.getContext();
        StyledResources res = new StyledResources(context);

        int color = ColorUtils.getColor(context, paletteColor);

        dialog.initialize(R.string.color_picker_default_title, res.getPalette(),
            color, 4, com.android.colorpicker.ColorPickerDialog.SIZE_SMALL);

        return dialog;
    }

    public void setListener(OnColorSelectedListener listener)
    {
        super.setOnColorSelectedListener(c -> {
            c = ColorUtils.colorToPaletteIndex(getContext(), c);
            listener.onColorSelected(c);
        });
    }

    public interface OnColorSelectedListener
    {
        void onColorSelected(int color);
    }
}