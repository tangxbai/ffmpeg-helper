package com.viiyue.ffmpeg.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Jaxb {

	private final Logger log = LoggerFactory.getLogger( Jaxb.class );
	private final ConcurrentMap<Class<?>, JAXBContext> jaxbContexts = new ConcurrentHashMap<>( 64 );

	private static final class Holder {
		private static final Jaxb INSTANCE = new Jaxb();
	}

	public static final Jaxb context() {
		return Holder.INSTANCE;
	}

	private Marshaller createMarshaller( Class<?> clazz ) {
		try {
			return getJaxbContext( clazz ).createMarshaller();
		} catch ( JAXBException ex ) {
			throw new RuntimeException( "Could not create Marshaller for class [" + clazz + "]: " + ex.getMessage(),
					ex );
		}
	}

	private Unmarshaller createUnmarshaller( Class<?> clazz ) {
		try {
			return getJaxbContext( clazz ).createUnmarshaller();
		} catch ( JAXBException ex ) {
			throw new RuntimeException( "Could not create Unmarshaller for class [" + clazz + "]: " + ex.getMessage(),
					ex );
		}
	}

	private JAXBContext getJaxbContext( Class<?> clazz ) {
		Assert.notNull( clazz, "Class must not be null" );
		JAXBContext jaxbContext = this.jaxbContexts.get( clazz );
		if ( jaxbContext == null ) {
			try {
				jaxbContext = JAXBContext.newInstance( clazz );
				this.jaxbContexts.putIfAbsent( clazz, jaxbContext );
			} catch ( JAXBException ex ) {
				throw new RuntimeException(
						"Could not instantiate JAXBContext for class [" + clazz + "]: " + ex.getMessage(), ex );
			}
		}
		return jaxbContext;
	}

	public String bean2Xml( Object bean ) {
		return toXml( bean, false, true );
	}

	public String bean2Xml( Object bean, boolean formatted ) {
		return toXml( bean, formatted, true );
	}

	public String toXml( Object bean, boolean formatted, boolean fragment ) {
		if ( bean != null ) {
			try {
				Class<?> clazz = bean.getClass();
				if ( clazz.isAnnotationPresent( XmlRootElement.class ) || clazz.isAnnotationPresent( XmlType.class ) ) {
					StringWriter writer = new StringWriter();
					Marshaller marshaller = createMarshaller( clazz );
					marshaller.setProperty( Marshaller.JAXB_ENCODING, CharEncoding.UTF_8 );
					marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, formatted );
					marshaller.setProperty( Marshaller.JAXB_FRAGMENT, fragment );
					marshaller.marshal( bean, writer );
					return writer.toString();
				}
			} catch ( MarshalException ex ) {
				log.error( "JAXB xml format error: " + ex.getMessage(), ex );
			} catch ( JAXBException ex ) {
				log.error( "Invalid JAXB setup: " + ex.getMessage(), ex );
			}
		}
		return StringUtils.EMPTY;
	}

	public final <T> T toBean( String xml, Class<T> beanType ) {
		if ( StringUtils.isEmpty( xml ) ) {
			return null;
		}
		try {
			StringReader reader = new StringReader( xml );
			Unmarshaller unmarshaller = createUnmarshaller( beanType );
			return ( T ) unmarshaller.unmarshal( reader );
		} catch ( UnmarshalException ex ) {
			log.error( "JAXB xml format error: " + ex.getMessage(), ex );
		} catch ( JAXBException ex ) {
			log.error( "Invalid JAXB setup: " + ex.getMessage(), ex );
		}
		return null;
	}

}
