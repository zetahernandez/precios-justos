/*
 * Copyright 2014 preciosjustosuda.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uda.utils;

import java.util.List;
import org.uda.preciosjustos.model.Input;
import org.uda.preciosjustos.model.Position;

/**
 *
 * @author octa
 */
public class EarthUtils {
    public static final double R = 6372.8; // Earth radio - kilometers
    
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    
    public static double distanceBetweenPositions(Position p1, Position p2){
        double distance;
        distance = haversine(   p1.getLatitude(),
                                p1.getLongitude(),
                                p2.getLatitude(),
                                p2.getLongitude() );
        return distance;
    }
    
    public static Input maxDistanceOfList(List<Input> inputs, Position reference){
        
        Input result = null;
        
        for (Input input : inputs) {
            //set first input
            if( result == null){
                result = input;
            }
            else{
                double reference_input = EarthUtils.distanceBetweenPositions(reference, input.getPosition());
                double reference_result = EarthUtils.distanceBetweenPositions( reference, result.getPosition() );
                
                if(reference_input > reference_result){
                    result = input;
                }
            }
        }
        return result;
    }
}
