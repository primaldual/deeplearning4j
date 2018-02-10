package org.deeplearning4j.arbiter.layers.fixed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.deeplearning4j.arbiter.layers.LayerSpace;
import org.deeplearning4j.arbiter.optimize.api.ParameterSpace;
import org.deeplearning4j.nn.conf.layers.Layer;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FixedLayerSpace<T extends Layer> extends LayerSpace<T> {

    protected T layer;

    @Override
    public T getValue(double[] parameterValues) {
        return (T)layer.clone();
    }

    @Override
    public int numParameters() {
        return 0;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public void setIndices(int[] idxs){
        if(idxs != null && idxs.length > 0){
            throw new IllegalStateException("Cannot set indices: no parameters");
        }
    }

    @Override
    public List<ParameterSpace> collectLeaves() {
        return Collections.<ParameterSpace>singletonList(this);
    }
}
