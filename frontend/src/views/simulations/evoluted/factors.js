import React, { Component } from "react";
import Select from "react-select";
import {
  CCol,
  CFormGroup,
  CFormText,
  CInput,
  CLabel,
  CRow,
} from "@coreui/react";

import distributions from './distributions';

const Factors = (props) => {
  return (
    <CRow>
      <CCol xs="12">
        <CFormGroup row>
          <CCol md="3" style={{ textAlign: "right" }}>
            <CLabel htmlFor={props.distributionId}>
              <b>{props.name}</b>
            </CLabel>
            <CFormText className="help-block">{props.title}</CFormText>
          </CCol>
          <CCol md="3" style={{ textAlign: "center" }}>
            <Select
              name={props.distributionId}
              id={props.distributionId}
              value={props.distributionValue}
              defaultValue={props.distributionDefaultValue}
              onChange={props.onChangeDistributions}
              options={distributions}
            />
            <CFormText className="help-block">{props.distributionText}</CFormText>
          </CCol>
          <CCol xs="4" md="2">
            <CInput
              id={props.factorId + "1"}
              type="number"
              min={props.min1}
              max={props.max1}
              step="0.1"
              value={props.value1}
              defaultValue={props.defaultValue1}
              placeholder={props.placeholder1 || "Enter factor value" }
              onChange={props.onChange}
              required={props.required1}
              disabled={props.disabled1}
            />
            <CFormText className="help-block">{props.arg1Text}</CFormText>
          </CCol>
          <CCol xs="4" md="2">
            <CInput
              id={props.factorId + "2"}
              type="number"
              min={props.min2}
              max={props.max2}
              step="0.1"
              value={props.value2}
              defaultValue={props.defaultValue2}
              placeholder={props.placeholder2 || "Enter factor value" }
              onChange={props.onChange}
              required={props.required2}
              disabled={props.disabled2}
            />
            <CFormText className="help-block">{props.arg2Text}</CFormText>
          </CCol>
          <CCol xs="4" md="2">
            <CInput
              id={props.factorId + "3"}
              type="number"
              min={props.min3}
              max={props.max3}
              step="0.1"
              value={props.value3}
              defaultValue={props.defaultValue3}
              placeholder={props.placeholder3 || "Enter factor value" }
              onChange={props.onChange}
              required={props.required3}
              disabled={props.disabled3}
            />
            <CFormText className="help-block">{props.arg3Text}</CFormText>
          </CCol>
        </CFormGroup>
      </CCol>
    </CRow>
  );
};

export default Factors;
