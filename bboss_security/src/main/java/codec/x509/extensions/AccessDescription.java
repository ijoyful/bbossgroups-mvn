/* ========================================================================
 *
 *  This file is part of CODEC, which is a Java package for encoding
 *  and decoding ASN.1 data structures.
 *
 *  Author: Fraunhofer Institute for Computer Graphics Research IGD
 *          Department A8: Security Technology
 *          Fraunhoferstr. 5, 64283 Darmstadt, Germany
 *
 *  Rights: Copyright (c) 2004 by Fraunhofer-Gesellschaft 
 *          zur Foerderung der angewandten Forschung e.V.
 *          Hansastr. 27c, 80686 Munich, Germany.
 *
 * ------------------------------------------------------------------------
 *
 *  The software package is free software; you can redistribute it and/or 
 *  modify it under the terms of the GNU Lesser General Public License as 
 *  published by the Free Software Foundation; either version 2.1 of the 
 *  License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public 
 *  License along with this software package; if not, write to the Free 
 *  Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 *  MA 02110-1301, USA or obtain a copy of the license at 
 *  http://www.fsf.org/licensing/licenses/lgpl.txt.
 *
 * ------------------------------------------------------------------------
 *
 *  The CODEC library can solely be used and distributed according to 
 *  the terms and conditions of the GNU Lesser General Public License for 
 *  non-commercial research purposes and shall not be embedded in any 
 *  products or services of any user or of any third party and shall not 
 *  be linked with any products or services of any user or of any third 
 *  party that will be commercially exploited.
 *
 *  The CODEC library has not been tested for the use or application 
 *  for a determined purpose. It is a developing version that can 
 *  possibly contain errors. Therefore, Fraunhofer-Gesellschaft zur 
 *  Foerderung der angewandten Forschung e.V. does not warrant that the 
 *  operation of the CODEC library will be uninterrupted or error-free. 
 *  Neither does Fraunhofer-Gesellschaft zur Foerderung der angewandten 
 *  Forschung e.V. warrant that the CODEC library will operate and 
 *  interact in an uninterrupted or error-free way together with the 
 *  computer program libraries of third parties which the CODEC library 
 *  accesses and which are distributed together with the CODEC library.
 *
 *  Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e.V. 
 *  does not warrant that the operation of the third parties's computer 
 *  program libraries themselves which the CODEC library accesses will 
 *  be uninterrupted or error-free.
 *
 *  Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e.V. 
 *  shall not be liable for any errors or direct, indirect, special, 
 *  incidental or consequential damages, including lost profits resulting 
 *  from the combination of the CODEC library with software of any user 
 *  or of any third party or resulting from the implementation of the 
 *  CODEC library in any products, systems or services of any user or 
 *  of any third party.
 *
 *  Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e.V. 
 *  does not provide any warranty nor any liability that utilization of 
 *  the CODEC library will not interfere with third party intellectual 
 *  property rights or with any other protected third party rights or will 
 *  cause damage to third parties. Fraunhofer Gesellschaft zur Foerderung 
 *  der angewandten Forschung e.V. is currently not aware of any such 
 *  rights.
 *
 *  The CODEC library is supplied without any accompanying services.
 *
 * ========================================================================
 */
package codec.x509.extensions;

import codec.asn1.ASN1IA5String;
import codec.asn1.ASN1ObjectIdentifier;
import codec.asn1.ASN1Sequence;
import codec.x509.GeneralName;

/**
 * AccessDescription ::= SEQUENCE { accessMethod OID, accessLocation
 * GeneralName}
 * 
 * @author cval
 * 
 * there are no "addValue" functions, because none parameter is optional, so it
 * must not be that one parameter is empty. the 2 constructors force either to
 * use the default values or to set both parameters during instantiating the
 * Object.
 */

public class AccessDescription extends ASN1Sequence {
    /**
     * the URL or LDAP Link to the OCSP Responder
     */
    private GeneralName accessLocation;

    /**
     * contains the OID of the Accessmehtod
     */
    private ASN1ObjectIdentifier accessMethod;

    /**
     * in case of an empty conctructor default values are set.
     */
    public AccessDescription() {
	accessLocation = new GeneralName();
	accessLocation.setUniformResourceIdentifier(new ASN1IA5String(
		"http://ocsptest:8080/ocsp"));
	accessMethod = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.48.1");

	add(accessMethod);
	add(accessLocation);
    }

    /**
     * the constructor as it should be used, with variable parameters.
     */
    public AccessDescription(ASN1ObjectIdentifier oid, GeneralName name) {
	if (oid == null || name == null) {
	    throw new NullPointerException("oid or name");
	}
	accessLocation = name;
	accessMethod = oid;
	add(accessMethod);
	add(accessLocation);
    }

    public String toString() {
	return "AccessDescription : accessMethod : " + accessMethod.toString()
		+ "\n  accessLocation : " + accessLocation.toString();
    }
}
