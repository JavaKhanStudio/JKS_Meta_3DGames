package tonegod.gui.controls.buttons;

import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;

public interface ButtonInterface 
{
    public abstract void onButtonMouseLeftDown(MouseButtonEvent evt, boolean toggled);

    public abstract void onButtonMouseRightDown(MouseButtonEvent evt, boolean toggled);

    public abstract void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggled);

    public abstract void onButtonMouseRightUp(MouseButtonEvent evt, boolean toggled);

    public abstract void onButtonFocus(MouseMotionEvent evt);

    public abstract void onButtonLostFocus(MouseMotionEvent evt);

}
