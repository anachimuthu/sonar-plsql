/*
 * Sonar PL/SQL Plugin (Community)
 * Copyright (C) 2015-2016 Felipe Zorzo
 * mailto:felipebzorzo AT gmail DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.plsqlopen.api.sql;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.sonar.plugins.plsqlopen.api.DmlGrammar;
import org.sonar.plugins.plsqlopen.api.RuleTest;

public class IntoClauseTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(DmlGrammar.INTO_CLAUSE);
    }
    
    @Test
    public void matchesSimpleIntoClause() {
        assertThat(p).matches("into var");
    }
    
    @Test
    public void matchesIntoClauseInMultipleVariables() {
        assertThat(p).matches("into var, var2");
    }
    
    @Test
    public void matchesBulkCollect() {
        assertThat(p).matches("bulk collect into var");
    }
    
    @Test
    public void matchesSimpleCollectionElement() {
        assertThat(p).matches("into col(1)");
    }
    
    @Test
    public void matchesSimpleIntoRecordItem() {
        assertThat(p).matches("into col.it");
    }
    
    @Test
    public void matchesSimpleIntoItemInRecordCollection() {
        assertThat(p).matches("into col(1).it");
    }

}
