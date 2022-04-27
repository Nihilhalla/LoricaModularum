package com.rainemaker.loricamodularum.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.Logger;

public class ScoutInit {
    private final Logger scout;
    private final Marker Warn = MarkerManager.getMarker("WARNING");
    private final Marker Info = MarkerManager.getMarker("INFO");
    private final Marker Log = MarkerManager.getMarker("LOG");
    private final Marker Debug = MarkerManager.getMarker("DEBUG");
    private final Marker Fatal = MarkerManager.getMarker("FATAL");
    private final Marker Error = MarkerManager.getMarker("ERROR");

    public ScoutInit(String name) {
        this.scout = LogManager.getLogger(name);
    }

    public Logger getInternal() {
        return this.scout;
    }

    public void info(String line) {
        this.scout.info(this.Info, line);
    }

    public void log(String line) {
        this.scout.info(this.Log, line);
    }

    public void debug(String debugString) {
        this.scout.debug(this.Debug, debugString);
    }

    public void warn(String line) {
        this.scout.warn(this.Warn, line);
    }

    public void fatal(String line) {
        this.scout.fatal(this.Fatal, line);
    }

    public void error(String line) {
        this.scout.error(this.Error, line);
    }

    public void catching(Throwable ex) {
        this.scout.catching(ex);
    }

}
