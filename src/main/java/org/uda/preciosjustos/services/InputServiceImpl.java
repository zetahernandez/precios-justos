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

package org.uda.preciosjustos.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uda.preciosjustos.dao.InputDao;
import org.uda.preciosjustos.model.Input;
import org.uda.preciosjustos.model.Position;
import org.uda.utils.EarthUtils;

/**
 *
 * @author octa
 */
@Service
public class InputServiceImpl implements InputService{
    
    @Autowired
    private InputDao inputDao;
    
    @Override
    public List<Input> closestInputs(Position clientPosition, int resultQuantiy) {
        
        List<Input> results = new ArrayList<Input>(resultQuantiy);
        List<Input> inputs = this.allInputs();//find by name
        
        for (Input input : inputs) {
            
            //insert inputs when array is not full
            if( results.size() < resultQuantiy - 1){
                results.add(input);
            }
            //when array is full
            else{
                //get farthest input to client position, of results array
                Input maxInput = EarthUtils.maxDistanceOfList(results, clientPosition);
                //get distance of farthest input
                double maxInputDistance = EarthUtils.distanceBetweenPositions(clientPosition, maxInput.getPosition());
                //get actual input distance to client
                double actualInputDistance = EarthUtils.distanceBetweenPositions(clientPosition, input.getPosition());
                
                //if exist new closest input, then replace
                if( actualInputDistance < maxInputDistance ){
                    results.remove(maxInput);
                    results.add(input);
                }
            }
        }
        return results;
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Input> allInputs() {
            return inputDao.listAll();
    }
    
    
    
}
