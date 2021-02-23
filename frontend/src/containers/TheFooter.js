import React from 'react'
import { CFooter } from '@coreui/react'

const TheFooter = () => {
  return (
    <CFooter fixed={true}>
      <div>
        <a href="https://efrem.ropelato.it" target="_blank" rel="noopener noreferrer">Efrem Ropelato</a>
        <span className="ml-1">&copy; 2020 </span>
      </div>
      <div className="mfs-auto">
        <span className="mr-1">Powered by</span>
        <a href="mailto:efrem.ropelato@gmail.com" target="_blank" rel="noopener noreferrer">Efrem Ropelato</a>
      </div>
    </CFooter>
  )
}

export default React.memo(TheFooter)
