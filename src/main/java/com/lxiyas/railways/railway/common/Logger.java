package com.lxiyas.railways.railway.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Logger {
    public static void log(String uuid, String data) {
        log.info(uuid +" " + data);
    }
}
