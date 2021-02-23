import React from 'react'
import CIcon from '@coreui/icons-react'

const _nav =  [
  {
    _tag: 'CSidebarNavItem',
    name: 'Home',
    to: '/dashboard',
    icon: <CIcon name="cil-speedometer" customClasses="c-sidebar-nav-icon"/>,
  },
  {
    _tag: 'CSidebarNavDropdown',
    name: 'Simulazioni',
    route: '/simulation',
    icon: 'cil-star',
    _children: [
      {
        _tag: 'CSidebarNavItem',
        name: 'Fattoriale',
        to: '/simulation/factorial',
      },
      {
        _tag: 'CSidebarNavItem',
        name: 'Evoluta',
        to: '/simulation/evoluted',
        badge: {
          color: 'success',
          text: 'NEW',
        },
      }
    ],
  },
]

export default _nav
