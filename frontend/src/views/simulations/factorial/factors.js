
import React, { Component } from 'react';
import {
  CCol,
  CFormGroup,
  CFormText,
  CInput,
  CLabel,
  CRow,
} from "@coreui/react";

const Factors = (props)=>{
    return (
      <CRow>
        <CCol xs="12">
          <CFormGroup row>
            <CCol md="8" style={{ textAlign: "right" }}>
              <CLabel htmlFor={props.factorId}>
                <b>{props.name}</b>{" "}
              </CLabel>
              <CFormText className="help-block">{props.title}</CFormText>
            </CCol>
            <CCol xs="12" md="4">
              <CInput
                name={props.factorId}
                id={props.factorId}
                type="number"
                min={props.min}
                max={props.max}
                step="0.1"
                value={props.value}
                defaultValue={props.defaultValue}
                placeholder={props.placeholder || "Enter factor value" }
                onChange={props.onChange}
                required
              />
              <CFormText className="help-block">{props.text}</CFormText>
            </CCol>
          </CFormGroup>
        </CCol>
      </CRow>
    );
  }

export default Factors;


