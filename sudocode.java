float currentPoint;
float lastPoint = 0;
float goalValue = 5; //Whatever constant you want the PID to Target
float pollTime;
Timer timer;

generalPID(){
    currentPoint = getEncoderValue();
    pollTime = timer.getValue();
    timer.reset();
    motor.set(kp*getP(goalValue, currentPoint)+kd*getD(currentPoint, lastPoint, pollTime)+ki*getI(goalValue, currentPoint, pollTime));
    lastPoint = currentPoint
}

// D
getD(float currentPoint, float lastPoint, float pollTime){
    return (currentPoint-lastPoint)/pollTime;
}

// P
getP(float goal, float current){
    return(current-goal);
}

//I
float currentI = 0;
float iGain;
getI(float goal, float current){
    iGain = (goal-current)*pollTime;
    currentI += iGain;
    return currentI;
}