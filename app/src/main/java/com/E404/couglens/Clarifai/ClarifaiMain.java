package com.E404.couglens.Clarifai;


import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.api.ClarifaiResponse;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.ConceptModel;
import clarifai2.dto.model.ModelVersion;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Prediction;


public class ClarifaiMain {

    private String filePath;

    public ClarifaiResponse<List<ClarifaiOutput<Prediction>>> getPredictions() {
        return predictions;
    }

    ClarifaiResponse<List<ClarifaiOutput<Prediction>>> predictions;

    public ClarifaiMain(String filePath) {
        this.filePath = filePath;
        callApi();
    }

    protected void callApi() {
        final ClarifaiClient client = new ClarifaiBuilder("e4c27199fe5e46dfb0ff50f84d6ee033").buildSync();

        ConceptModel model = client.getDefaultModels().generalModel();
        //ModelVersion modelVersion = model.getVersionByID("the-version").executeSync().get();

        ClarifaiResponse<List<ClarifaiOutput<Prediction>>> response = client.predict(model.id())
                .withInputs(ClarifaiInput.forImage(filePath))
                .withVersion("aa7f35c01e0642fda5cf400f543e7c40")
                .executeSync();

        predictions = response;
    }

}
