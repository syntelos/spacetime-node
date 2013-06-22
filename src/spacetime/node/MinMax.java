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
 * The type <code>F</code> number must implement
 * <code>Comparable&lt;F&gt;</code>.
 *
 * This class employs double type comparisons in the corner case when
 * "F" type comparisons are unavailable.  These two methods, {@link
 * #equals} and {@link #compareTo}, may be overridden when this
 * operation would be incorrect.
 */
public abstract class MinMax<F extends Number>
    extends Number
    implements Comparable<MinMax<F>>
{

    public F min, max;


    public MinMax(){
        super();
    }

    public MinMax(F... minmax){
        super();
        this.update(minmax);
    }


    public int compareTo(MinMax<F> that){
        if (this == that)
            return 0;
        else 
            return new Double(this.doubleValue()).compareTo(that.doubleValue());
    }
    public void update(F arg){

        if (null == this.min)
            this.min = arg;
        else {

            final int n = ((Comparable<F>)arg).compareTo(this.min);

            if (0 > n){
                F tmp = this.min;
                this.min = arg;
                if (null == this.max){
                    this.max = tmp;
                }
            }
            else if (0 < n){
                if (null == this.max)
                    this.max = arg;
                else {

                    final int x = ((Comparable<F>)arg).compareTo(this.max);

                    if (0 < x){

                        this.max = arg;
                    }
                }
            }
        }
    }
    public void update(F... minmax){

        final int len = minmax.length;

        switch(len){
        case 0:
            break;
        case 1:
            this.update(minmax[0]);
            break;
        case 2:
            this.update(minmax[0]);
            this.update(minmax[1]);
            break;
        default:

            for (int cc = 0; cc < len; cc++){
                this.update(minmax[cc]);
            }
        }
    }
    public int intValue(){
        final F min = this.min;
        final F max = this.max;

        if (null != min){

            if (null != max){

                return (min.intValue()+max.intValue())>>1;
            }
            else
                return min.intValue();
        }
        else if (null != max){

            return max.intValue();
        }
        else
            return 0;
    }
    public long longValue(){
        final F min = this.min;
        final F max = this.max;

        if (null != min){

            if (null != max){

                return (min.longValue()+max.longValue())>>1;
            }
            else
                return min.longValue();
        }
        else if (null != max){

            return max.longValue();
        }
        else
            return 0;
    }
    public float floatValue(){
        final F min = this.min;
        final F max = this.max;

        if (null != min){

            if (null != max){

                return (min.floatValue()+max.floatValue())/2.0f;
            }
            else
                return min.floatValue();
        }
        else if (null != max){

            return max.floatValue();
        }
        else
            return 0;
    }
    public double doubleValue(){
        final F min = this.min;
        final F max = this.max;

        if (null != min){

            if (null != max){

                return (min.doubleValue()+max.doubleValue())/2.0;
            }
            else
                return min.doubleValue();
        }
        else if (null != max){

            return max.doubleValue();
        }
        else
            return 0;
    }
    public int hashCode(){
        return this.intValue();
    }
    public String toString(){
        final F min = this.min;
        final F max = this.max;

        StringBuilder string = new StringBuilder();
        string.append('{');
        if (null != min){
            string.append(min);
            if (null != max){
                string.append(',');
                string.append(max);
            }
        }
        string.append('}');
        return string.toString();
    }
    public boolean equals(Object that){
        if (this == that)
            return true;

        else if (that instanceof Number)

            return (0 != new Double(this.doubleValue()).compareTo( ((Number)that).doubleValue()));
        else
            return false;
    }
}
