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
package org.sonar.plsqlopen;

import javax.annotation.Nullable;

import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.utils.ValidationMessages;
import org.sonar.plsqlopen.checks.CheckList;
import org.sonar.squidbridge.annotations.AnnotationBasedProfileBuilder;

public class PlSqlProfile extends ProfileDefinition {

    private final RuleFinder ruleFinder;

    public PlSqlProfile(RuleFinder ruleFinder) {
      this.ruleFinder = ruleFinder;
    }

    @Override
    public RulesProfile createProfile(@Nullable ValidationMessages validation) {
      AnnotationBasedProfileBuilder annotationBasedProfileBuilder = new AnnotationBasedProfileBuilder(ruleFinder);
      return annotationBasedProfileBuilder.build(
          CheckList.REPOSITORY_KEY,
          CheckList.SONAR_WAY_PROFILE,
          PlSql.KEY,
          CheckList.getChecks(),
          validation);
    }

}
