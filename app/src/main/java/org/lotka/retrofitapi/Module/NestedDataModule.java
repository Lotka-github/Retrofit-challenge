package org.lotka.retrofitapi.Module;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NestedDataModule {
    @SerializedName("flowers")
    @Expose
    private StandardJsonModule[] standardJsonModuleNestedModule  ;

    public StandardJsonModule[] getStandardJsonModuleNestedModule() {
        return standardJsonModuleNestedModule;
    }

    public void setStandardJsonModuleNestedModule(StandardJsonModule[] standardJsonModuleNestedModule) {
        this.standardJsonModuleNestedModule = standardJsonModuleNestedModule;
    }
}
