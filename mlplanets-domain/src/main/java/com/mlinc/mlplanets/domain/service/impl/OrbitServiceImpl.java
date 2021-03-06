package com.mlinc.mlplanets.domain.service.impl;

import com.mlinc.mlplanets.domain.model.Orbit;
import com.mlinc.mlplanets.domain.service.OrbitService;

import java.awt.geom.Point2D;

public class OrbitServiceImpl implements OrbitService {

    private static final int CIRCLE_DEGRESS = 360;

    @Override
    public Point2D getPositionForDay(Orbit orbit, long day) {
        return new Point2D.Double(
                orbit.getDistance() * Math.cos(getOrbitAngleInRadians(orbit, day)),
                orbit.getDistance() * Math.sin(getOrbitAngleInRadians(orbit, day))
        );
    }

    @Override
    public long getYearDurationInDays(Orbit orbit) {
        // 360 grados / velocidad angular en grados
        return CIRCLE_DEGRESS / Math.abs(orbit.getAngularSpeed());
    }

    private double getOrbitAngleInRadians(Orbit orbit, long day) {
        return Math.toRadians(orbit.getAngularSpeed() * day);
    }
}
