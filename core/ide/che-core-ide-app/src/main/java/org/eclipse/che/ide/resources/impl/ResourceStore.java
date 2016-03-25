package org.eclipse.che.ide.resources.impl;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;

import org.eclipse.che.ide.api.resources.Container;
import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.resource.Path;

/**
 * The resource store is responsible for caching resources on the client.
 * <p/>
 * At this moment there is only one implementation of storage which handles cached resources in memory.
 * So browser page refreshing will reset storage.
 * <p/>
 * Note, that this interface is not intended to be implemented by third party components.
 *
 * @author Vlad Zhukovskiy
 * @see InMemoryResourceStore
 * @since 4.0.0-RC14
 */
@Beta
interface ResourceStore {
    /**
     * Register the given {@code resource} with parent path in storage.
     * <p/>
     * If {@code resource}'s parent is root path, then {@link Path#ROOT} should be used.
     *
     * @param parent
     *         the resource parent path
     * @param resource
     *         the resource to be registered
     * @return {@code true} if given resource hasn't registered before
     * @throws IllegalArgumentException
     *         if argument checking was failed, reasons include:
     *         <ul>
     *         <li>Null parent occurred</li>
     *         <li>Null resource occurred</li>
     *         </ul>
     * @since 4.0.0-RC14
     */
    boolean register(Path parent, Resource resource);

    /**
     * Dispose given {@code resource} and dispose children if {@code withChildren} was flagged as {@code true}.
     * <p/>
     * Disposing {@link Path#ROOT} will be equality to calling {@link #clear()}.
     *
     * @param path
     *         the path to be disposed
     * @param withChildren
     *         {@code true} if nested descendants should be disposed if given {@code path} is bound to {@link Container}.
     * @throws IllegalArgumentException
     *         if argument checking was failed, reasons include:
     *         <ul>
     *         <li>Null path occurred</li>
     *         </ul>
     * @since 4.0.0-RC14
     */
    void dispose(Path path, boolean withChildren);

    /**
     * Returns the {@link Optional} with resource by given {@code path}.
     * <p/>
     * If there was no any resource registered, {@link Optional#absent()} is returned.
     *
     * @param path
     *         the path to the resource
     * @return the {@link Optional} with resource, otherwise {@link Optional#absent()}
     * @throws IllegalArgumentException
     *         if argument checking was failed, reasons include:
     *         <ul>
     *         <li>Null path occurred</li>
     *         </ul>
     * @since 4.0.0-RC14
     */
    Optional<Resource> getResource(Path path);

    /**
     * Returns the descendants of the given {@code parent}.
     * <p/>
     * If there was no any {@code parent} registered, {@link Optional#absent()} is returned.
     *
     * @param parent
     *         the parent path, which descendants should be fetched
     * @return the {@link Optional} with descendants array, otherwise {@link Optional#absent()}
     * @throws IllegalArgumentException
     *         if argument checking was failed, reasons include:
     *         <ul>
     *         <li>Null path occurred</li>
     *         </ul>
     * @since 4.0.0-RC14
     */
    Optional<Resource[]> get(Path parent);

    /**
     * Returns the all descendants of the given {@code parent}.
     * <p/>
     * If there was no any {@code parent} registered, {@link Optional#absent()} is returned.
     *
     * @param parent
     *         the parent path, which descendants should be fetched
     * @return the {@link Optional} with descendants array, otherwise {@link Optional#absent()}
     * @throws IllegalArgumentException
     *         if argument checking was failed, reasons include:
     *         <ul>
     *         <li>Null path occurred</li>
     *         </ul>
     * @since 4.0.0-RC14
     */
    Optional<Resource[]> getAll(Path parent);

    /**
     * Clears the store.
     *
     * @since 4.0.0-RC14
     */
    void clear();
}
