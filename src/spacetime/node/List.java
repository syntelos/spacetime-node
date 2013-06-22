/*
 * Spacetime Node
 * Copyright (C) 2013, John Pritchard.
 * 
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package spacetime.node;

/**
 * Domain ordered set of nodes
 */
public class List<E extends Enum<E>, S extends SpacetimeNode>
    extends lxl.ArrayList<S>
    implements SpacetimeDomain<E,S>
{

    public final E domain;


    public List(E domain){
        super();
        if (null != domain)
            this.domain = domain;
        else
            throw new IllegalStateException();
    }


    public final E getSpacetimeDomain(){
        return this.domain;
    }
}
