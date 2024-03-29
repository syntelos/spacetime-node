/*
 * Spacetime
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

import java.util.StringTokenizer;

/**
 * This file is generated by the build scripts.  
 */
public final class Version {
    /**
     * Package system name
     */
    public final static java.lang.String Name = "spacetime-node";
    /**
     * Major version number
     */
    public final static int Major = 1;
    /**
     * Minor version number
     */
    public final static int Minor = 0;
    /**
     * Build sequence number
     */
    public final static int Build = 1;
    /**
     * <code>" Major '.' Minor '.' Build "</code>.
     */
    public final static java.lang.String Number = String.valueOf(Major)+'.'+Minor+'.'+Build;
    /**
     * <code>" Name '/' Major '.' Minor "</code>.
     */
    public final static java.lang.String Short = Name+'/'+Major+'.'+Minor;
    /**
     * <code>" Name '/' Number "</code>.
     */
    public final static java.lang.String Long = Name+'/'+Number;


    public final String string, name;
    public final Integer major, minor, build;


    /**
     * Generic version string parser.  Throws exceptions on parsing
     * integers, otherwise sets strings or numbers to null for missing
     * information.
     */
    public Version(String string){
        super();

        String name = null;

        Integer major = null, minor = null, build = null;

        if (null != string && 0 < string.length()){

            this.string = string;
            /*
             */
            final int idx = string.indexOf('/');
            if (-1 < idx){
                name = string.substring(0,idx);
                string = string.substring(idx+1);
            }
            /*
             */
            final StringTokenizer strtok = new StringTokenizer(string,".");
            final int count = strtok.countTokens();

            switch(count){
            case 1:
                major = new Integer(strtok.nextToken());
                break;
            case 2:
                major = new Integer(strtok.nextToken());
                minor = new Integer(strtok.nextToken());
                break;
            case 3:
                major = new Integer(strtok.nextToken());
                minor = new Integer(strtok.nextToken());
                build = new Integer(strtok.nextToken());
                break;
            default:
                break;
            }
        }
        else {
            this.string = null;
        }
        this.name = name;
        this.major = major;
        this.minor = minor;
        this.build = build;
    }


    public boolean isEmpty(){
        return (null == this.name && null == this.major);
    }
    public boolean isNotEmpty(){
        return (null != this.name || null != this.major);
    }
    public boolean hasName(){
        return (null != this.name);
    }
    public boolean hasNumbers(){
        return (null != this.major && null != this.minor && null != this.build);
    }
    public boolean hasNumbers2(){
        return (null != this.major && null != this.minor);
    }
    public boolean hasNumbers1(){
        return (null != this.major);
    }
    public String toString(){
        return string;
    }
}
