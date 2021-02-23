import React, { Component } from "react";
import Select from "react-select";
import {
  CButton,
  CCard,
  CCardBody,
  CCardFooter,
  CCardHeader,
  CCol,
  CForm,
  CFormGroup,
  CInput,
  CLabel,
  CRow,
  CTabs,
  CTabContent,
  CTabPane,
  CNav,
  CNavItem,
  CNavLink,
} from "@coreui/react";
import {
  CChartLine,
} from "@coreui/react-chartjs";
import CIcon from "@coreui/icons-react";
import _ from "lodash";

import Factors from './factors';
import ResultFactors from './resultFactors';
import factors from '../factors';
import distributions from './distributions';

class Evoluted extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rsl: "0",
      dA: distributions[0],
      fA1: "0.8",
      fA2: "1",
      fA3: "1.2",
      dB: distributions[0],
      fB1: "0.8",
      fB2: "1",
      fB3: "1.2",
      dC: distributions[0],
      fC1: "0.8",
      fC2: "1",
      fC3: "1.2",
      dD: distributions[0],
      fD1: "0.8",
      fD2: "1",
      fD3: "1.2",
      dE: distributions[0],
      fE1: "0.8",
      fE2: "1",
      fE3: "1.2",
      dF: distributions[0],
      fF1: "0.8",
      fF2: "1",
      fF3: "1.2",
      dG: distributions[0],
      fG1: "0.8",
      fG2: "1",
      fG3: "1.2",
      esl: null,
      factA: null,
      factB: null,
      factC: null,
      factD: null,
      factE: null,
      factF: null,
      factG: null,
      iterations: { value: 10000, label: "10000 iterazioni" },
      excel: false
    };
    this.updateDistributions = this.updateDistributions.bind(this);
    this.updateIterations = this.updateIterations.bind(this);
    this.updateFactor = this.updateFactor.bind(this);
    this.updateESL = this.updateESL.bind(this);
    this.reset = this.reset.bind(this);
  }

  updateESL() {
    const _this = this;
    const data = {
      fatA1: this.state.fA1,
      fatB1: this.state.fB1,
      fatC1: this.state.fC1,
      fatD1: this.state.fD1,
      fatE1: this.state.fE1,
      fatF1: this.state.fF1,
      fatG1: this.state.fG1,
      fatA2: this.state.fA2,
      fatB2: this.state.fB2,
      fatC2: this.state.fC2,
      fatD2: this.state.fD2,
      fatE2: this.state.fE2,
      fatF2: this.state.fF2,
      fatG2: this.state.fG2,
      fatA3: this.state.fA3,
      fatB3: this.state.fB3,
      fatC3: this.state.fC3,
      fatD3: this.state.fD3,
      fatE3: this.state.fE3,
      fatF3: this.state.fF3,
      fatG3: this.state.fG3,
      RSL: this.state.rsl,
      iterations: this.state.iterations.value || 0,
      excel: this.state.excel,
      distrA: this.state.dA.value,
      distrB: this.state.dB.value,
      distrC: this.state.dC.value,
      distrD: this.state.dD.value,
      distrE: this.state.dE.value,
      distrF: this.state.dF.value,
      distrG: this.state.dG.value
    }
    fetch('/api/esl/evolved',
      {
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(data)
      })
      .then(response => response.json())
      .then(data => {
        _this.setState({
          esl: data.ESL.graficoESL,
          eslSeries: _.chain(data.ESL.graficoESL.values)
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          eslLabels: _.chain(data.ESL.graficoESL.values)
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factA: data.FatA.graficoFatA,
          factASeries: _.chain(data.FatA.graficoFatA.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factALabels: _.chain(data.FatA.graficoFatA.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factB: data.FatB.graficoFatB,
          factBSeries: _.chain(data.FatB.graficoFatB.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factBLabels: _.chain(data.FatB.graficoFatB.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factC: data.FatC.graficoFatC,
          factCSeries: _.chain(data.FatC.graficoFatC.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factCLabels: _.chain(data.FatC.graficoFatC.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factD: data.FatD.graficoFatD,
          factDSeries: _.chain(data.FatD.graficoFatD.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factDLabels: _.chain(data.FatD.graficoFatD.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factE: data.FatE.graficoFatE,
          factESeries: _.chain(data.FatE.graficoFatE.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factELabels: _.chain(data.FatE.graficoFatE.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factF: data.FatF.graficoFatF,
          factFSeries: _.chain(data.FatF.graficoFatF.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factFLabels: _.chain(data.FatF.graficoFatF.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
          factG: data.FatG.graficoFatG,
          factGSeries: _.chain(data.FatG.graficoFatG.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.count),
          factGLabels: _.chain(data.FatG.graficoFatG.values[0])
            .groupBy((x) => { return Math.floor(x * 100) })
            .map((v, k) => ({
              cluster: k/100,
              count: v.length,
            }))
            .orderBy(['cluster'], ['asc'])
            .value()
            .map((a) => a.cluster),
        },()=>{
          if (_this.state.excel) {
            document.getElementById("filename").innerHTML =
              data.response.filename;
            document.getElementById("filename").href =
              "./assets/" + data.response.filename;
            document
              .getElementById("filename")
              .setAttribute("style", "display:block;");
            document
              .getElementById("dlexcel")
              .setAttribute("style", "display:block;");
          }
        });
      });
  }

  updateFactor(event) {
    const value = event.target.value;
    const name = event.target.id;
    this.state[name] = value;
    this.setState(this.state);
  }

  updateDistributions(distribution, event) {
    const value = distribution;
    const name = event.name;
    this.state[name] = value;
    this.setState(this.state);
  }

  updateIterations(interation, event) {
    const value = interation;
    const name = event.name;
    this.state[name] = value;
    this.setState(this.state);
  }

  reset(){
    this.setState({
      rsl: "0",
      dA: distributions[0],
      fA1: "1",
      fA2: "1",
      fA3: "1",
      dB: distributions[0],
      fB1: "1",
      fB2: "1",
      fB3: "1",
      dC: distributions[0],
      fC1: "1",
      fC2: "1",
      fC3: "1",
      dD: distributions[0],
      fD1: "1",
      fD2: "1",
      fD3: "1",
      dE: distributions[0],
      fE1: "1",
      fE2: "1",
      fE3: "1",
      dF: distributions[0],
      fF1: "1",
      fF2: "1",
      fF3: "1",
      dG: distributions[0],
      fG1: "1",
      fG2: "1",
      fG3: "1",
      esl: null,
      factA: null,
      factB: null,
      factC: null,
      factD: null,
      factE: null,
      factF: null,
      factG: null,
      iterations: { value: 10000, label: "10000 iterazioni" },
      excel: false
    })
  }

  render() {
    return (
      <>
        <CRow>
          <CCol xs="12" sm="6">
            <CCard>
              <CCardHeader>
                Metodo Fattoriale
                <small> [ RSL * f(A) * f(B) * f(C) * f(D) * f(E) * f(F) * f(G) ]</small>
                {/* <DocsLink name="-Input" /> */}
              </CCardHeader>
              <CCardBody>
                <CForm
                  action=""
                  method="post"
                  encType="multipart/form-data"
                  className="form-horizontal"
                >
                  <CRow>
                    <CCol xs="12">
                      <CFormGroup row>
                        <CCol md="6" style={{ textAlign: "right" }}>
                          <CLabel htmlFor="rsl">
                            <b>Reference Service Life</b>
                          </CLabel>
                        </CCol>
                        <CCol xs="6" md="3">
                          <CInput
                            id="rsl"
                            type="number"
                            value={this.state.rsl}
                            placeholder="Enter Reference Service Life"
                            onChange={this.updateFactor}
                            required
                          />
                        </CCol>
                        <CCol xs="6" md="3">
                          <Select
                            name="iterations"
                            id="dA"
                            defaultValue={this.state.iterations}
                            onChange={this.updateIterations}
                            options={[
                              { value: 100, label: "100 iterazioni" },
                              { value: 500, label: "500 iterazioni" },
                              { value: 1000, label: "1000 iterazioni" },
                              { value: 10000, label: "10000 iterazioni" },
                              { value: 50000, label: "50000 iterazioni" },
                              { value: 100000, label: "100000 iterazioni", isDisabled: true },
                            ]}
                          />
                        </CCol>
                      </CFormGroup>
                    </CCol>
                  </CRow>
                  {_.map(factors,(f)=>{
                    return (
                      <Factors
                        key={f.factorId}
                        distributionId={f.distributionId}
                        name={f.name}
                        title={f.title}
                        distributionValue={this.state[f.distributionId]}
                        onChangeDistributions={this.updateDistributions}
                        distributionText="Distribution"
                        factorId={f.factorId}
                        min1="0.8"
                        max1="1.2"
                        value1={this.state[f.distributionId].arg1 ? this.state[f.factorId + "1"] : "0"}
                        onChange={this.updateFactor}
                        required1={this.state[f.distributionId].arg1}
                        disabled1={!this.state[f.distributionId].arg1}
                        arg1Text={this.state[f.distributionId].arg1}
                        min2="0.8"
                        max2="1.2"
                        value2={this.state[f.distributionId].arg2 ? this.state[f.factorId + "2"] : "0"}
                        required2={this.state[f.distributionId].arg2}
                        disabled2={!this.state[f.distributionId].arg2}
                        arg2Text={this.state[f.distributionId].arg2}
                        min3="0.8"
                        max3="1.2"
                        value3={this.state[f.distributionId].arg3 ? this.state[f.factorId + "3"] : "0"}
                        required3={this.state[f.distributionId].arg3}
                        disabled3={!this.state[f.distributionId].arg3}
                        arg3Text={this.state[f.distributionId].arg3}
                        />
                      )
                    })
                  }
                </CForm>
              </CCardBody>
              <CCardFooter>
                <CButton size="sm" color="primary" onClick={this.updateESL}>
                  <CIcon name="cil-scrubber" /> Submit
                </CButton>
                <CButton type="reset" size="sm" color="danger" onClick={this.reset}>
                  <CIcon name="cil-ban" /> Reset
                </CButton>
              </CCardFooter>
            </CCard>
          </CCol>
          <CCol xs="12" sm="6">
            <CCard>
              <CCardHeader>Estimated service life</CCardHeader>
              <CCardBody>
                <CTabs>
                  <CNav variant="tabs">
                    <CNavItem>
                      <CNavLink>ESL</CNavLink>
                    </CNavItem>
                    {_.map(factors, (f)=>{
                      return(
                        <CNavItem key={f.factorId}>
                          <CNavLink>{f.name}</CNavLink>
                        </CNavItem>
                      )
                    })}
                  </CNav>
                  <CTabContent>
                    <CTabPane>
                        {this.state.esl ? (
                      <div style={{ textAlign: "center" }}>
                        <h2>Estimated service life</h2>
                          <CRow>
                            <CCol>
                              <div id="esl">
                                <ul>
                                  <li>Min: {this.state.esl.minimo}</li>
                                  <li>Perc 10%: {this.state.esl.perc10}</li>
                                  <li>Media: {this.state.esl.media}</li>
                                  <li>Dev.Std.: {this.state.esl.devstd}</li>
                                  <li>Perc 90%: {this.state.esl.perc90}</li>
                                  <li>Max: {this.state.esl.massimo}</li>
                                </ul>
                              </div>
                            </CCol>
                            <CCol>
                              <CChartLine
                                datasets={[
                                  {
                                    label: "Values",
                                    backgroundColor: "rgb(228,102,81,0.9)",
                                    data: this.state.eslSeries
                                      ? this.state.eslSeries
                                      : [],
                                  },
                                ]}
                                options={{
                                  tooltips: {
                                    enabled: true,
                                  },
                                }}
                                labels={
                                  this.state.eslLabels
                                    ? this.state.eslLabels
                                    : []
                                }
                              />
                            </CCol>
                          </CRow>
                      </div>
                        ) : <p>- - -</p>}
                    </CTabPane>
                    {_.map(factors, (f)=>{
                      return(
                        <CTabPane key={f.factorId}>
                          {this.state.esl ? (
                            <ResultFactors
                              title={f.title}
                              result={this.state[f.resultId] ? this.state[f.resultId] : "---"}
                              data={this.state[f.resultId + "Series"] ? this.state[f.resultId + "Series"] : []}
                              labels={this.state[f.resultId + "Labels"] ? this.state[f.resultId + "Labels"] : []}
                            />
                          ): <p>- - -</p>}
                        </CTabPane>
                      )
                    })}
                  </CTabContent>
                </CTabs>
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
      </>
    );
  }
}

export default Evoluted;
