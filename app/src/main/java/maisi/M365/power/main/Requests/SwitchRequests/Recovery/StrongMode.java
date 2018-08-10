package maisi.M365.power.main.Requests.SwitchRequests.Recovery;

import java.util.Arrays;

import maisi.M365.power.main.IRequest;
import maisi.M365.power.main.RequestType;
import maisi.M365.power.util.NbCommands;
import maisi.M365.power.util.NbMessage;

public class WeakMode implements IRequest {
    private static int delay = 100;
    private final String requestBit = "7C";
    private final RequestType requestType = RequestType.CRUISE;
    private long startTime;

    public WeakMode() {
        this.startTime = System.currentTimeMillis() + delay;
    }

    @Override
    public int getDelay() {
        return delay;
    }

    @Override
    public String getRequestString() {
        return new NbMessage()
                .setDirection(NbCommands.MASTER_TO_M365)
                .setRW(NbCommands.WRITE)
                .setPosition(0x7C)
                .setPayload(0x0000)
                .build();
    }

    @Override
    public String getRequestBit() {
        return requestBit;
    }

    @Override
    public String handleResponse(String[] request) {
        return Arrays.toString(request);
    }

    @Override
    public RequestType getRequestType() {
        return requestType;
    }
}
