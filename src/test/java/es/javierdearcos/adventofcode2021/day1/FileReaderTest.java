/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package es.javierdearcos.adventofcode2021.day1;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Javier de Arcos
 */
public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    @Test
    public void testRead() throws IOException, URISyntaxException {
        List<Integer> expectedMeasures = List.of(199, 200, 208, 210, 200, 207, 240, 269, 260 ,263);

        List<Integer> readMeasures = fileReader.read("/day1/fileReaderSample.txt");

        assertEquals(expectedMeasures, readMeasures);
    }
}
