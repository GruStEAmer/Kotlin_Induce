package Classes

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice protected constructor(
    val name: String,
    )
{

    open fun turnOn(){
        println("Smart device is turned on")
    }
    open fun turnOff(){
        println("Smart Device is turned off")
    }
}

class SmartTVDevice(deviceName: String) :
    SmartDevice(name = deviceName)
{
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun deincreaseSpeakerVolume(){
        speakerVolume--
        println("Speaker volume deincreased to $speakerVolume")
    }
    fun nextChannel(){
        channelNumber++;
        println("Channel number increased to $channelNumber")
    }
}

class SmartLightDevice(deviceName:String, deviceCategory:String):
    SmartDevice(name = deviceName)
{
    private var deviceStatus:String = "off"

   private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    override fun turnOn(){
        deviceStatus = "on"
        println("$name turned $deviceStatus. The brightness level is $brightnessLevel")
    }

    override fun turnOff() {
        deviceStatus = "off"
        println("$name turned $deviceStatus. The brightness level is $brightnessLevel")
    }
}

class SmartHome(
    private val smartTVDevice: SmartTVDevice,
    private val smartLightDevice: SmartLightDevice,
)
{
    fun turnOnTv(){
        smartTVDevice.turnOn()
    }
    fun turnOffTv(){
        smartTVDevice.turnOff()
    }
    fun increasedTvVolume(){
        smartTVDevice.increaseSpeakerVolume()
    }
    fun changeTvChannelNext(){
        smartTVDevice.nextChannel()
    }

    fun turnOnLight(){
        smartLightDevice.turnOn()
    }
    fun turnOffLight(){
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevice(){
        turnOffTv()
        turnOffLight()
    }

}

class RangeRegulator(
    initialValue:Int,
    private val minValue:Int,
    private val maxValue:Int
): ReadWriteProperty<Any? , Int>{
    var fieldData  = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int{
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
        if(value in minValue..maxValue) fieldData = value
    }
}