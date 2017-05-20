/**
 * Sencha GXT 4.0.0 - Sencha for GWT
 * Copyright (c) 2006-2015, Sencha Inc.
 *
 * licensing@sencha.com
 * http://www.sencha.com/products/gxt/license/
 *
 * ================================================================================
 * Open Source License
 * ================================================================================
 * This version of Sencha GXT is licensed under the terms of the Open Source GPL v3
 * license. You may use this license only if you are prepared to distribute and
 * share the source code of your application under the GPL v3 license:
 * http://www.gnu.org/licenses/gpl.html
 *
 * If you are NOT prepared to distribute and share the source code of your
 * application under the GPL v3 license, other commercial and oem licenses
 * are available for an alternate download of Sencha GXT.
 *
 * Please see the Sencha GXT Licensing page at:
 * http://www.sencha.com/products/gxt/license/
 *
 * For clarification or additional options, please contact:
 * licensing@sencha.com
 * ================================================================================
 *
 *
 * ================================================================================
 * Disclaimer
 * ================================================================================
 * THIS SOFTWARE IS DISTRIBUTED "AS-IS" WITHOUT ANY WARRANTIES, CONDITIONS AND
 * REPRESENTATIONS WHETHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION THE
 * IMPLIED WARRANTIES AND CONDITIONS OF MERCHANTABILITY, MERCHANTABLE QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, DURABILITY, NON-INFRINGEMENT, PERFORMANCE AND
 * THOSE ARISING BY STATUTE OR FROM CUSTOM OR USAGE OF TRADE OR COURSE OF DEALING.
 * ================================================================================
 */
package com.sencha.gxt.widget.core.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.sencha.gxt.core.shared.event.CancellableEvent;
import com.sencha.gxt.widget.core.client.event.BeforeCollapseEvent.BeforeCollapseHandler;

/**
 * Fires before an item is collapsed.
 */
public class BeforeCollapseEvent extends GwtEvent<BeforeCollapseHandler> implements CancellableEvent {

  /**
   * A widget that implements this interface is a public source of
   * {@link BeforeCollapseEvent} events.
   */
  public interface HasBeforeCollapseHandlers {

    /**
     * Adds a {@link BeforeCollapseHandler} handler for {@link BeforeCollapseEvent}
     * events.
     * 
     * @param handler the handler
     * @return the registration for the event
     */
    HandlerRegistration addBeforeCollapseHandler(BeforeCollapseHandler handler);
  }

  
  /**
   * Handler class for {@link BeforeCollapseEvent} events.
   */
  public interface BeforeCollapseHandler extends EventHandler {

    /**
     * Called before a content panel is collapsed. Listeners can cancel the action
     * by calling {@link BeforeCollapseEvent#setCancelled(boolean)}.
     */
    void onBeforeCollapse(BeforeCollapseEvent event);
  }
  
  /**
   * Handler type.
   */
  private static Type<BeforeCollapseHandler> TYPE;

  /**
   * Gets the type associated with this event.
   * 
   * @return returns the handler type
   */
  public static Type<BeforeCollapseHandler> getType() {
    return TYPE != null ? TYPE : (TYPE = new Type<BeforeCollapseHandler>());
  }

  private boolean cancelled;

  


  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Type<BeforeCollapseHandler> getAssociatedType() {
    return (Type) TYPE;
  }


  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }

  @Override
  protected void dispatch(BeforeCollapseHandler handler) {
    handler.onBeforeCollapse(this);
  }

}