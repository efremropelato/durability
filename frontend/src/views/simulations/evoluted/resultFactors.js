import React, {Component} from 'react';
import {
  CCol,
  CRow,
} from "@coreui/react";
import {
  CChartLine,
} from "@coreui/react-chartjs";

const resultFactors = (props) => {
  return (
    <div style={{textAlign: "center"}}>
      <h2>{props.title}</h2>
      <CRow>
        <CCol>
          <ul>
            <li>Min: {props.result.minimo}</li>
            <li>Perc 10%: {props.result.perc10}</li>
            <li>Media: {props.result.media}</li>
            <li>Dev.Std.: {props.result.devstd}</li>
            <li>Perc 90%: {props.result.perc90}</li>
            <li>Max: {props.result.massimo}</li>
          </ul>
        </CCol>
        <CCol>
          <CChartLine
            datasets={[
              {
                label: "Values",
                backgroundColor: "rgb(228,102,81,0.9)",
                data: props.data,
              },
            ]}
            options={{
              tooltips: {
                enabled: true,
              },
            }}
            labels={props.labels}
          />
        </CCol>
      </CRow>
    </div>
  );
}

export default resultFactors;
