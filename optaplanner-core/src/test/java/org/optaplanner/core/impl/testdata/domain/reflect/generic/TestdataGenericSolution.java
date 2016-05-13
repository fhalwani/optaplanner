/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.core.impl.testdata.domain.reflect.generic;

import java.util.List;
import java.util.Map;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.core.impl.domain.solution.descriptor.SolutionDescriptor;
import org.optaplanner.core.impl.testdata.domain.TestdataObject;

@PlanningSolution
public class TestdataGenericSolution<T> extends TestdataObject {

    public static SolutionDescriptor buildSolutionDescriptor() {
        return SolutionDescriptor.buildSolutionDescriptor(TestdataGenericSolution.class, TestdataGenericEntity.class);
    }

    private List<TestdataGenericValue<T>> valueList;
    private List<TestdataGenericValue<Map<T, TestdataGenericValue<T>>>> complexGenericValueList;
    private List<TestdataGenericEntity<T>> entityList;

    private SimpleScore score;

    public TestdataGenericSolution() {
    }

    public TestdataGenericSolution(String code) {
        super(code);
    }

    public TestdataGenericSolution(String code, List<TestdataGenericValue<T>> valueList,
            List<TestdataGenericValue<Map<T, TestdataGenericValue<T>>>> complexGenericValueList,
            List<TestdataGenericEntity<T>> entityList) {
        super(code);
        this.valueList = valueList;
        this.complexGenericValueList = complexGenericValueList;
        this.entityList = entityList;
    }

    @ValueRangeProvider(id = "valueRange")
    @ProblemFactCollectionProperty
    public List<TestdataGenericValue<T>> getValueList() {
        return valueList;
    }

    @ValueRangeProvider(id = "complexGenericValueRange")
    @ProblemFactCollectionProperty
    public List<TestdataGenericValue<Map<T, TestdataGenericValue<T>>>> getComplexGenericValueList() {
        return complexGenericValueList;
    }

    @PlanningEntityCollectionProperty
    public List<TestdataGenericEntity<T>> getEntityList() {
        return entityList;
    }

    @PlanningScore
    public SimpleScore getScore() {
        return score;
    }

    public void setScore(SimpleScore score) {
        this.score = score;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
