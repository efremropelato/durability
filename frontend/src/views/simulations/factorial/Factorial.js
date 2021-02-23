import React, { Component } from "react";
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
} from "@coreui/react";
import CIcon from "@coreui/icons-react";

import _ from 'lodash';

import Factors from './factors';
import factors from '../factors';

class Factorial extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rsl: "0",
      fA: "1",
      fB: "1",
      fC: "1",
      fD: "1",
      fE: "1",
      fF: "1",
      fG: "1",
      esl: null,
    };
    this.updateFactor = this.updateFactor.bind(this);
    this.updateESL = this.updateESL.bind(this);
    this.reset = this.reset.bind(this);
  }

  updateESL() {
    const _this = this;
    const data = {
      fatA: this.state.fA,
      fatB: this.state.fB,
      fatC: this.state.fC,
      fatD: this.state.fD,
      fatE: this.state.fE,
      fatF: this.state.fF,
      fatG: this.state.fG,
      RSL: this.state.rsl
    }
    fetch('/api/esl',
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
            esl: data,
          });
        });
  }

  updateFactor(event) {
    const value = event.target.value;
    const name = event.target.id;
    this.state[name] = value;
    this.setState(this.state);
  }

  reset(){
    this.setState({
      rsl: "0",
      fA: "1",
      fB: "1",
      fC: "1",
      fD: "1",
      fE: "1",
      fF: "1",
      fG: "1",
      esl: null,
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
                <small> [ RSL * A * B * C * D * E * F * G ]</small>
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
                        <CCol md="8" style={{ textAlign: "right" }}>
                          <CLabel htmlFor="rsl">
                            <b>Reference Service Life</b>
                          </CLabel>
                        </CCol>
                        <CCol xs="12" md="4">
                          <CInput
                            id="rsl"
                            type="number"
                            value={this.state.rsl}
                            placeholder="Enter Reference Service Life"
                            onChange={this.updateFactor}
                            required
                          />
                        </CCol>
                      </CFormGroup>
                    </CCol>
                  </CRow>
                  {_.map(factors,(f)=>{
                    return (
                      <Factors
                        key={f.factorId}
                        factorId={f.factorId}
                        name={f.name}
                        title={f.title}
                        min={f.min}
                        max={f.max}
                        value={this.state[f.factorId]}
                        placeholder={f.placeholder}
                        onChange={this.updateFactor}
                        text={f.text}
                        />
                    )
                  })}
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
                <div style={{ textAlign: "center" }}>
                  <h2>Estimated service life</h2>
                  <b>
                    <h1
                      id="esl"
                      style={{
                        color:
                          this.state.esl < this.state.rsl ? "red" : "green",
                      }}
                    >
                      {this.state.esl ? this.state.esl : "---"}
                    </h1>
                  </b>
                </div>
              </CCardBody>
            </CCard>
          </CCol>
        </CRow>
      </>
    );
  }
}

export default Factorial;
