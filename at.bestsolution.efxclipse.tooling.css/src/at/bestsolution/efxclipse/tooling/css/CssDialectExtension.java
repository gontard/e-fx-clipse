/*******************************************************************************
 * Copyright (c) 2011 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.efxclipse.tooling.css;

import static at.bestsolution.efxclipse.tooling.css.CssDialectExtension.Util.fromList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osgi.framework.Version;

import at.bestsolution.efxclipse.tooling.css.cssDsl.css_declaration;

public interface CssDialectExtension {
	public enum ValidationStatus {
		OK,
		WARNING,
		ERROR
	}
	
	public static class ValidationResult {
		public final ValidationStatus status;
		public final String message;
		public final EObject object;
		public final EStructuralFeature feature;
		public final int index;
		
		public ValidationResult(ValidationStatus status, String message, EObject object, EStructuralFeature feature, int index) {
			this.status = status;
			this.message = message;
			this.object = object;
			this.feature = feature;
			this.index = index;
		}
		
		@Override
		public String toString() {
			return status.name() + " - " + message;
		}
	}
	
	public abstract static class Property {
		private final String name;
		private final String description;
		private final Version minVersion;
		
		public Property(String name) {
			this(name,new Version("2.0.0"));
		}
		
		public Property(String name, Version minVersion) {
			this(name, null,new Version("2.0.0"));
		}
		
		public Property(String name, String description) {
			this(name, description,new Version("2.0.0"));
		}
		
		public Property(String name, String description, Version minVersion) {
			this.name = name;
			this.description = description;
			this.minVersion = minVersion == null ? new Version("2.0.0") : minVersion;
		}
		
		public Version getMinVersion() {
			return minVersion;
		}
		
		public String getName() {
			return name;
		}
		
		public String getDescription() {
			return description;
		}
		
		public abstract List<Proposal> getInitialTermProposals();
		
		public ValidationResult[] validate(css_declaration dec) {
			return new ValidationResult[0];
		}
	}
	
	public interface MultiValuesGroupProperty {
//		public List<Proposal> getNextTermProposal(int index, termGroup currentGroup, term term);
	}
	
	public interface MultiTermGroupProperty {
		public List<Proposal> getInitialTermProposal(int index, css_declaration currentDeclaration);
	}
	
	public static class IntegerProperty extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();
		
		public IntegerProperty(String name) {
			super(name);
			proposals.add(new Proposal("0"));
			proposals.add(new Proposal("1"));
			proposals.add(new Proposal("inherit"));
		}
		
		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				if( dec.getExpression().getTermGroups().size() > 1 ) {
//					return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple term groups", null, null, -1) };
//				} else if( dec.getExpression().getTermGroups().size() == 1 ) {
//					if( dec.getExpression().getTermGroups().get(0).getTerms().size() > 1 ) {
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple terms", null, null, -1) };
//					} else if( dec.getExpression().getTermGroups().get(0).getTerms().size() == 1 ) {
//						String number = dec.getExpression().getTermGroups().get(0).getTerms().get(0).getNumber();
//						
//						if( number == null ) {
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not a integer value", null, null, -1) };	
//						} else {
//							try {
//								double d = Double.parseDouble(number);	
//								if( d != (int)d ) {
//									return new ValidationResult[] { new ValidationResult(ValidationStatus.WARNING, "The value is floating point number but should be an integer", null, null, -1) };	
//								}
//							} catch( NumberFormatException e ) {
//								return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not a integer value", null, null, -1) };	
//							}
//							
//						}
//					}
//				}
//			}
			return super.validate(dec);
		}
	}
	
	public static class StringProperty extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();
		
		public StringProperty(String name) {
			super(name);
		}
		
		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
	}
	
	public static class BooleanProperty extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();

		public BooleanProperty(String name) {
			super(name);
			proposals.addAll(fromList("true","false"));
		}
		
		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				if( dec.getExpression().getTermGroups().size() > 1 ) {
//					return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple term groups", null, null, -1) };
//				} else if( dec.getExpression().getTermGroups().size() == 1 ) {
//					if( dec.getExpression().getTermGroups().get(0).getTerms().size() > 1 ) {
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple terms", null, null, -1) };
//					} else if( dec.getExpression().getTermGroups().get(0).getTerms().size() == 1 ) {
//						String value = dec.getExpression().getTermGroups().get(0).getTerms().get(0).getIdentifier();
//						
//						if( value == null || ! ( value.equals("true") || value.equals("false") ) ) {
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is true or false", null, null, -1) };	
//						}
//					}
//				}
//			}
			return super.validate(dec);
		}
	}
	
	public static class NumberPropery extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();

		public NumberPropery(String name) {
			super(name);
		}
		
		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				if( dec.getExpression().getTermGroups().size() > 1 ) {
//					return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple term groups", null, null, -1) };
//				} else if( dec.getExpression().getTermGroups().size() == 1 ) {
//					if( dec.getExpression().getTermGroups().get(0).getTerms().size() > 1 ) {
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple terms", null, null, -1) };
//					} else if( dec.getExpression().getTermGroups().get(0).getTerms().size() == 1 ) {
//						String number = dec.getExpression().getTermGroups().get(0).getTerms().get(0).getNumber();
//						
//						if( number == null ) {
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not a floating point number", null, null, -1) };	
//						} else {
//							try {
//								Double.parseDouble(number);	
//							} catch( NumberFormatException e ) {
//								return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not a floating point number", null, null, -1) };	
//							}
//							
//						}
//					}
//				}
//			}
			return super.validate(dec);
		}
	}
	
	public static class EnumProperty extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();
				
		public EnumProperty(String name, String... enums) {
			this(name,null,enums);
		}
		
		public EnumProperty(Version minVersion, String name, String... enums) {
			this(name,null,enums);
		}

		public EnumProperty(String name, String description, String... enums) {
			this(null,name,null,enums);
		}
		
		public EnumProperty(Version minVersion, String name, String description, String... enums) {
			super(name, description, minVersion);
			proposals.addAll(fromList(enums));
			proposals.add(new Proposal("inherit"));
		}
		
		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				if( dec.getExpression().getTermGroups().size() > 1 ) {
//					return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple term groups", null, null, -1) };
//				} else if( dec.getExpression().getTermGroups().size() == 1 ) {
//					if( dec.getExpression().getTermGroups().get(0).getTerms().size() > 1 ) {
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple terms", null, null, -1) };
//					} else if( dec.getExpression().getTermGroups().get(0).getTerms().size() == 1 ) {
//						String id = dec.getExpression().getTermGroups().get(0).getTerms().get(0).getIdentifier();
//						for( Proposal p : proposals ) {
//							if( p.getProposal().equalsIgnoreCase(id) ) {
//								return new ValidationResult[0];
//							}
//						}
//						
//						StringBuilder b = new StringBuilder();
//						for( Proposal p: proposals ) {
//							b.append("- " + p.getProposal());
//							if( p.getLabel() != null && ! p.getLabel().equals(p.getProposal()) ) {
//								b.append(": " +p.getLabel());
//							}
//							b.append("\n");
//						}
//						
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value has to be:\n" + b, null, null, -1) };
//					}
//				}
//			}
			return super.validate(dec);
		}
	}
	
	public static class UrlProperty extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();

		public UrlProperty(String name) {
			super(name);
			proposals.add(new Proposal("url(\"resource\")"));
			proposals.add(new Proposal("url('resource')"));
		}

		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				if( dec.getExpression().getTermGroups().size() > 1 ) {
//					return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple term groups", null, null, -1) };
//				} else if( dec.getExpression().getTermGroups().size() == 1 ) {
//					if( dec.getExpression().getTermGroups().get(0).getTerms().size() > 1 ) {
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple terms", null, null, -1) };
//					} else if( dec.getExpression().getTermGroups().get(0).getTerms().size() == 1 ) {
//						URLType url = dec.getExpression().getTermGroups().get(0).getTerms().get(0).getUrl();
//						
//						if( url == null || url.getUrl().trim().length() == 0 ) {
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not an url", null, null, -1) };
//						} else {
//							try {
//								new java.net.URI(url.getUrl());
//							} catch (URISyntaxException e) {
//								return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not an url", null, null, -1) };
//							}
//							
//						}
//					}
//				}
//			}
			return super.validate(dec);
		}
	}
	
	public static class UrlsProperty extends Property {
		private List<Proposal> proposals = new ArrayList<Proposal>();

		public UrlsProperty(String name) {
			super(name);
			proposals.add(new Proposal("url(\"resource\")"));
			proposals.add(new Proposal("url('resource')"));
		}

		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				for( termGroup g : dec.getExpression().getTermGroups() ) {
//					if( g.getTerms().size() > 1 ) {
//						return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple terms", null, null, -1) };
//					} else if( g.getTerms().size() == 1 ) {
//						URLType url = g.getTerms().get(0).getUrl();
//						
//						if( url == null || url.getUrl().trim().length() == 0 ) {
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not an url", g.getTerms().get(0), CssDslPackage.Literals.TERM__URL, -1) };
//						} else {
//							try {
//								new java.net.URI(url.getUrl());
//							} catch (URISyntaxException e) {
//								return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value is not an url", null, null, -1) };
//							}
//							
//						}
//					}
//				}
//			}
			return super.validate(dec);
		}
	}
	
	public static class EnumsProperty extends Property implements MultiValuesGroupProperty {
		private List<Proposal> proposals = new ArrayList<Proposal>();
		private List<Proposal> singleTerms = new ArrayList<Proposal>();
		private int partCount;
		
		public EnumsProperty(String name, int partCount, String... enums) {
			this(name,null,partCount,enums);
		}
		
		public EnumsProperty(String name, String description, int partCount, String... enums) {
			super(name, description);
			this.partCount = partCount;
			
			for( String v : enums ) {
				StringBuilder b = new StringBuilder();
				for( int i = 0; i < partCount; i++ ) {
					if( b.length() > 0 ) {
						b.append(" ");
					}
					b.append(v);
				}
				proposals.add(new Proposal(v));
				proposals.add(new Proposal(b.toString()));
				singleTerms.add(new Proposal(v));
			}
		}
		
		@Override
		public List<Proposal> getInitialTermProposals() {
			return proposals;
		}

//		@Override
//		public List<Proposal> getNextTermProposal(int index,
//				termGroup currentGroup, term term) {
//			if( index < partCount ) {
//				return singleTerms;
//			}
//			return Collections.emptyList();
//		}
		
		@Override
		public ValidationResult[] validate(css_declaration dec) {
//			if( dec.getExpression() != null ) {
//				if( dec.getExpression().getTermGroups().size() > 1 ) {
//					return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The attribute does not support multiple term groups", null, null, -1) };
//				} else if( dec.getExpression().getTermGroups().size() == 1 ) {
//					if( dec.getExpression().getTermGroups().get(0).getTerms().size() == 1 ) {
//						String value = dec.getExpression().getTermGroups().get(0).getTerms().get(0).getIdentifier();
//						
//						StringBuilder b = new StringBuilder();
//						for( Proposal p: singleTerms ) {
//							b.append("- " + p.getProposal());
//							if( p.getLabel() != null && ! p.getLabel().equals(p.getProposal()) ) {
//								b.append(": " +p.getLabel());
//							}
//							b.append("\n");
//						}
//						
//						if( value == null ) {
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value has to be:\n" + b, null, null, -1) };	
//						} else if( ! "inherit".equals(value) ) {
//							for( Proposal p : singleTerms ) {
//								if( value.equals(p.getProposal()) ) {
//									return super.validate(dec);
//								}
//							}
//							
//							return new ValidationResult[] { new ValidationResult(ValidationStatus.ERROR, "The value has to be:\n" + b, dec.getExpression().getTermGroups().get(0).getTerms().get(0), CssDslPackage.Literals.TERM__IDENTIFIER, -1) };
//						}
//						
//					} else if( dec.getExpression().getTermGroups().get(0).getTerms().size() == partCount ) {
//						StringBuilder b = new StringBuilder();
//						for( Proposal p: singleTerms ) {
//							b.append("- " + p.getProposal());
//							if( p.getLabel() != null && ! p.getLabel().equals(p.getProposal()) ) {
//								b.append(": " +p.getLabel());
//							}
//							b.append("\n");
//						}
//						
//						List<ValidationResult> rv = new ArrayList<ValidationResult>();
//						
//						for( term t : dec.getExpression().getTermGroups().get(0).getTerms() ) {
//							String value = t.getIdentifier();
//							
//							if( value == null ) {
//								rv.add(new ValidationResult(ValidationStatus.ERROR, "The value has to be:\n" + b, null, null, -1));
//							} else {
//								boolean v = false;
//								for( Proposal p : singleTerms ) {
//									if( value.equals(p.getProposal()) ) {
//										v = true;
//									}
//								}
//								if( ! v ) {
//									rv.add(new ValidationResult(ValidationStatus.ERROR, "The value has to be:\n" + b, t, CssDslPackage.Literals.TERM__IDENTIFIER, -1) );
//								}
//							}
//						}
//						
//						if( rv.isEmpty() ) {
//							return super.validate(dec);
//						} else {
//							return rv.toArray(new ValidationResult[0]);
//						}
//					}
//				}
//			}
//			
			return super.validate(dec);
		}
	}
	
	public static class Proposal {
		private String proposal;
		private String label;
		private String imageUrl;
		private int priority = 1;
		
		public Proposal(String label) {
			this.proposal = label;
			this.label = label;
		}
		
		public Proposal(int priority, String label) {
			this.priority = priority;
			this.proposal = label;
			this.label = label;
		}

		public String getProposal() {
			return proposal;
		}
		
		public String getImageUrl() {
			return imageUrl;
		}
		
		public String getLabel() {
			return label;
		}
		
		public int getPriority() {
			return priority;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "'" + proposal + "'";
		}
	}
	
	public static abstract class DialogProposal extends Proposal {
		public DialogProposal(String label) {
			super(label);
		}
		
		public DialogProposal(int priority, String label) {
			super(priority,label);
		}
		
		public abstract String openProposal();
	}
	
	public static class Util {
		public static class DescribedName {
			private final String name;
			private final String description;
			
			public DescribedName(String name, String description) {
				this.name = name;
				this.description = description;
			}
			
			public static DescribedName c(String name, String description) {
				return new DescribedName(name, description);
			}
		}
		
		public static List<Proposal> fromList(String... strings) {
			List<Proposal> rv = new ArrayList<Proposal>();
			for( String s : strings ) {
				rv.add(new Proposal(s));
			}
			return rv;
		}
		
		public static List<Property> createEnumProperties(List<String> enums, String... names) {
			List<Property> rv = new ArrayList<Property>(names.length);
			String[] arEnums = enums.toArray(new String[0]);
			
			for( String name : names ) {
				rv.add(new EnumProperty(name, arEnums));
			}
			
			return rv;
		}
		
		public static List<Property> createEnumProperties(Version minVersion, List<String> enums, String... names) {
			List<Property> rv = new ArrayList<Property>(names.length);
			String[] arEnums = enums.toArray(new String[0]);
			
			for( String name : names ) {
				rv.add(new EnumProperty(name, arEnums));
			}
			
			return rv;
		}
		
		public static List<Property> createEnumProperties(List<String> enums, DescribedName... names) {
			List<Property> rv = new ArrayList<Property>(names.length);
			String[] arEnums = enums.toArray(new String[0]);
			
			for( DescribedName name : names ) {
				rv.add(new EnumProperty(name.name, name.description, arEnums));
			}
			
			return rv;
		}
		
		public static List<Property> createEnumsProperties(List<String> enums, int partCount, String... names) {
			List<Property> rv = new ArrayList<Property>(names.length);
			String[] arEnums = enums.toArray(new String[0]);
			
			for( String name : names ) {
				rv.add(new EnumsProperty(name, partCount, arEnums));
			}
			
			return rv;
		}
		
		public static List<Property> createEnumsProperties(List<String> enums, int partCount, DescribedName... names) {
			List<Property> rv = new ArrayList<Property>(names.length);
			String[] arEnums = enums.toArray(new String[0]);
			
			for( DescribedName name : names ) {
				rv.add(new EnumsProperty(name.name, name.description, partCount, arEnums));
			}
			
			return rv;
		}
		
		public static List<Property> createReflective(Class<? extends Property> clazz, String... names) {
			List<Property> rv = new ArrayList<Property>(names.length);
			Constructor<? extends Property> c;
			try {
				c = clazz.getConstructor(String.class);
				for( String name : names ) {
					rv.add(c.newInstance(name));
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
			return rv;
		}
		
//		public static ValidationResult checkNumber(term term, String message) {
//			try {
//				Double.parseDouble(term.getNumber());
//			} catch (NumberFormatException e) {
//				return new ValidationResult(ValidationStatus.ERROR, message, term, null, -1);
//			}
//			return null;
//		}
		
//		public static ValidationResult checkPercentage(term term, String message, int min, int max) {
//			if( term.getNumber().matches("^\\d+(\\.\\d+)?%$") || term.getNumber().matches("^-\\d+(\\.\\d+)?%$") || term.getNumber().matches("^\\+\\d+(\\.\\d+)?%$") ) {
//				double v = Double.parseDouble(term.getNumber().substring(0, term.getNumber().length()-1));
//				if( v < min * 1.0 || v > max * 1.0 ) {
//					return new ValidationResult(ValidationStatus.ERROR, message, term, null, -1);
//				}
//			} else {
//				return new ValidationResult(ValidationStatus.ERROR, message, term, null, -1);
//			}
//			return null;
//		}
	}
	
	public List<Property> getProperties();
	public boolean isActive(URI uri);
}
