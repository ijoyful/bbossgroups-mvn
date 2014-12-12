/*
 * Copyright (c) 1998-2003 by The FlexiProvider Group,
 *                            Technische Universitaet Darmstadt 
 *
 * For conditions of usage and distribution please refer to the
 * file COPYING in the root directory of this package.
 *
 */
package de.flexiprovider.core.saferplusplus;

import de.flexiprovider.api.Registry;
import de.flexiprovider.api.SecureRandom;
import de.flexiprovider.api.exceptions.InvalidAlgorithmParameterException;
import de.flexiprovider.api.keys.SecretKey;
import de.flexiprovider.api.keys.SecretKeyGenerator;
import de.flexiprovider.api.parameters.AlgorithmParameterSpec;

/**
 * This class is used to generate keys for the SAFER++ block cipher. Values for
 * the key size are 128 and 256 bits, with the default being 128 bits.
 * 
 * @author Martin Strese
 * @author Marcus Lippert
 */
public class SAFERPlusPlusKeyGenerator extends SecretKeyGenerator {

    // the key size in bits
    private int keySize;

    // the source of randomness
    private SecureRandom random;

    // flag indicating whether the key generator has been initialized
    private boolean initialized;

    /**
     * Initialize the key generator with the given parameters (which have to be
     * an instance of {@link SAFERPlusPlusKeyGenParameterSpec}) and a source of
     * randomness. If the parameters are <tt>null</tt>, the
     * {@link SAFERPlusPlusKeyGenParameterSpec#SAFERPlusPlusKeyGenParameterSpec() default parameters}
     * are used.
     * 
     * @param params
     *                the parameters
     * @param random
     *                the source of randomness
     * @throws InvalidAlgorithmParameterException
     *                 if the parameters are <tt>null</tt> or not an instance
     *                 of {@link SAFERPlusPlusKeyGenParameterSpec}.
     */
    public void init(AlgorithmParameterSpec params, SecureRandom random)
	    throws InvalidAlgorithmParameterException {

	SAFERPlusPlusKeyGenParameterSpec saferPlusPlusParams;
	if (params == null) {
	    saferPlusPlusParams = new SAFERPlusPlusKeyGenParameterSpec();
	} else if (params instanceof SAFERPlusPlusKeyGenParameterSpec) {
	    saferPlusPlusParams = (SAFERPlusPlusKeyGenParameterSpec) params;
	} else {
	    throw new InvalidAlgorithmParameterException("unsupported type");
	}

	keySize = saferPlusPlusParams.getKeySize() >> 3;
	this.random = random != null ? random : Registry.getSecureRandom();

	initialized = true;
    }

    /**
     * Initialize the key generator with the given key size and source of
     * randomness. If the key size is invalid, the
     * {@link SAFERPlusPlusKeyGenParameterSpec#DEFAULT_KEY_SIZE default key size}
     * is chosen.
     * 
     * @param keySize
     *                the key size (128, 192, or 256 bits)
     * @param random
     *                the source of randomness
     */
    public void init(int keySize, SecureRandom random) {
	SAFERPlusPlusKeyGenParameterSpec params = new SAFERPlusPlusKeyGenParameterSpec(
		keySize);
	try {
	    init(params, random);
	} catch (InvalidAlgorithmParameterException e) {
	    // the parameters are correct and must be accepted
	    throw new RuntimeException("internal error");
	}
    }

    /**
     * Initialize the key generator with the default SAFERPlusPlus parameters
     * and the given source of randomness.
     * 
     * @param random
     *                the source of randomness
     */
    public void init(SecureRandom random) {
	SAFERPlusPlusKeyGenParameterSpec defaultParams = new SAFERPlusPlusKeyGenParameterSpec();
	try {
	    init(defaultParams, random);
	} catch (InvalidAlgorithmParameterException e) {
	    // the parameters are correct and must be accepted
	    throw new RuntimeException("internal error");
	}
    }

    /**
     * Generate a SAFER++ key.
     * 
     * @return the generated {@link SAFERPlusPlusKey}
     */
    public SecretKey generateKey() {
	if (!initialized) {
	    init(Registry.getSecureRandom());
	}

	byte[] keyBytes = new byte[keySize];
	random.nextBytes(keyBytes);

	return new SAFERPlusPlusKey(keyBytes);
    }

}
