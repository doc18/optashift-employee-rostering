/*
 * Copyright (C) 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.openshift.employeerostering.gwtui.client.rostergrid.model;

import java.util.stream.Stream;

public interface Blob<T> {

    T getPositionInScaleUnits();

    void setPositionInScaleUnits(final T position);

    double getSizeInGridPixels();

    void setSizeInGridPixels(final double sizeInGridPixels);

    LinearScale<T> getScale();

    default double getPositionInGridPixels() {
        return getScale().toGridPixels(getPositionInScaleUnits());
    }

    default T getEndPositionInScaleUnits() {
        return getScale().toScaleUnits(getEndPositionInGridPixels());
    }

    default double getEndPositionInGridPixels() {
        return getPositionInGridPixels() + getSizeInGridPixels();
    }

    default boolean collidesWith(final Blob<?> other) {
        return getEndPositionInGridPixels() > other.getPositionInGridPixels() && other.getEndPositionInGridPixels() > getPositionInGridPixels();
    }

    default Stream<Blob<T>> toStream() {
        return Stream.of(this);
    }
}
