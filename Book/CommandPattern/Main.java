import Controls.Fan.CeilingFan;
import Controls.Fan.CeilingFanOffCommand;
import Controls.Fan.CeilingFanOnCommand;
import Controls.GarageDoors.GarageDoor;
import Controls.GarageDoors.GarageDoorCloseCommand;
import Controls.GarageDoors.GarageDoorOpenCommand;
import Controls.Lights.Light;
import Controls.Lights.LightOffCommand;
import Controls.Lights.LightOnCommand;
import Controls.Stereos.SetereoOnCommand;
import Controls.Stereos.Stereo;
import Controls.Stereos.StereoOffCommand;

public class Main {
    public static void main(String[] args) {
       SimpleRemoteControl remote = new SimpleRemoteControl();

       Light livingRoomLight = new Light("Living room");
       Light kitchenLight = new Light("Kitchen");
       CeilingFan ceilingFan = new CeilingFan("Living room");
       GarageDoor garageDoor = new GarageDoor();
       Stereo stereo = new Stereo("Living room");

       LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
       LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
       LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
       LightOffCommand kitcheLightOffCommand = new LightOffCommand(kitchenLight);

       CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
       CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

       GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
       GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

       SetereoOnCommand setereoOnCommand = new SetereoOnCommand(stereo);
       StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

       remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
       remote.setCommand(1, kitchenLightOnCommand, kitcheLightOffCommand);
       remote.setCommand(2, ceilingFanOnCommand, ceilingFanOffCommand);
       remote.setCommand(3, setereoOnCommand, stereoOffCommand);

       remote.onButtonWasPushed(0);
       remote.offButtonWasPushed(0);
       System.out.println(remote);
       remote.undoButtonWasPushed();
       remote.offButtonWasPushed(0);
       remote.onButtonWasPushed(0);
       System.out.println(remote);
       remote.undoButtonWasPushed();
    //    remote.onButtonWasPushed(1);
    //    remote.offButtonWasPushed(1);
    //    remote.onButtonWasPushed(2);
    //    remote.offButtonWasPushed(2);
    //    remote.onButtonWasPushed(3);
    //    remote.offButtonWasPushed(3);
    //    remote.onButtonWasPushed(4);
    //    remote.offButtonWasPushed(4);

       
    }
}
