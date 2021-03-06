package JKS.T3D.Clavier;

import com.jme3.input.controls.ActionListener;

import JKS.T3D.Data.Charac_Main;
import JKS.T3D.Enums.Enum_Animation;

public class Control_Clavier implements ActionListener 
{

    @Override
    public void onAction(String binding, boolean value, float tpf) 
    {
        if (binding.equals("Strafe Left")) 
        {
            if (value) 
            {Charac_Main.physicsCharacter.input.leftStrafe = true;} 
            else 
            {Charac_Main.physicsCharacter.input.leftStrafe = false;}
        } 
        else if (binding.equals("Strafe Right")) 
        {
            if (value) 
            {Charac_Main.physicsCharacter.input.rightStrafe = true;} 
            else 
            {Charac_Main.physicsCharacter.input.rightStrafe = false;}
        } 
        else if (binding.equals("Rotate Left")) 
        {
            if (value) 
            {Charac_Main.physicsCharacter.input.leftRotate = true;} 
            else 
            {Charac_Main.physicsCharacter.input.leftRotate = false;}
        } 
        else if (binding.equals("Rotate Right")) 
        {
            if (value) 
            {Charac_Main.physicsCharacter.input.rightRotate = true;} 
            else 
            {Charac_Main.physicsCharacter.input.rightRotate = false;}
        } 
        else if (binding.equals("Walk Forward")) 
        {
            if (value) 
            {Charac_Main.physicsCharacter.input.forward = true;} 
            else 
            {Charac_Main.physicsCharacter.input.forward = false;}
        } 
        else if (binding.equals("Walk Backward")) 
        {
            if (value) 
            {Charac_Main.physicsCharacter.input.backward = true;} 
            else 
            {Charac_Main.physicsCharacter.input.backward = false;}
        } 
        else if (binding.equals("Jump")) 
        {
        	if(Charac_Main.visualCharacter.getCurrentAnimation().equalsIgnoreCase(Enum_Animation.JUMPING_STAY.animName))
        		return ; 
        	
        	Charac_Main.physicsCharacter.jump();
        	Charac_Main.visualCharacter.setTheAnimation(Enum_Animation.JUMPING_STAY, false);
        	
        }
        else if(binding.equals("Test1")) {
//        	inputManager.clearMappings();
//        	Utils_Clavier_GJ.setupKeysId(8,true);
//        	Init_Camera.initCameraThirdPersonFromHigh();
//        	fromTopMove() ;
        }
    }
}
